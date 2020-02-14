package com.example.componentsplant.security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author Wladimir Litvinov
 */
@EnableWebSecurity
@AllArgsConstructor
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    private final LoadUserDetailService userDetailsService;
    private final JwtRequestFilter jwtRequestFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                //.httpBasic()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/clients/*").hasRole(UserRole.CLIENT.name())
                .antMatchers(HttpMethod.POST, "/clients/*").hasRole(UserRole.CLIENT.name())
                .antMatchers(HttpMethod.GET, "/admin/*").hasRole(UserRole.ADMIN.name())
                .antMatchers(HttpMethod.GET, "/director/*").hasRole(UserRole.DIRECTOR.name())
                .antMatchers(HttpMethod.GET, "/storekeeper/*").hasRole(UserRole.STOREKEEPER.name())
                .antMatchers(HttpMethod.POST, "/clients/sign-in", "/clients/sign-up").permitAll()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .formLogin().disable();
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}