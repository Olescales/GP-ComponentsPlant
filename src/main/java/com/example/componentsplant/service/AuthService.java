package com.example.componentsplant.service;

import com.example.componentsplant.dto.EmployeeSignUpRequest;
import com.example.componentsplant.entity.AuthInfoEntity;
import com.example.componentsplant.entity.UserEntity;
import com.example.componentsplant.exception.SuchClientAlreadyExistsException;
import com.example.componentsplant.mapper.EmployeeSingUpRequestMapper;
import com.example.componentsplant.repository.AuthInfoRepository;
import com.example.componentsplant.repository.UserRepository;
import com.example.componentsplant.security.UserRole;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class AuthService {

    private final AuthInfoRepository authInfoRepository;
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final EmployeeSingUpRequestMapper employeeSingUpRequestMapper;

    @Transactional
    public void signUp (final EmployeeSignUpRequest request) throws SuchClientAlreadyExistsException {
        if (authInfoRepository.findByLogin(request.getLogin()).isPresent()) {
            throw new SuchClientAlreadyExistsException("User with email=" + request.getLogin() + " already exists");
        }
        saveUser(request);
    }
    private void saveUser(final EmployeeSignUpRequest request) {
        final UserEntity userEntity = employeeSingUpRequestMapper.sourceToDestination(request);
        userEntity.setUserRole(UserRole.CLIENT);
        final UserEntity savedUser = userRepository.save(userEntity);
        saveAuthInfo(request, savedUser);
    }

    private void saveAuthInfo(final EmployeeSignUpRequest request, final UserEntity savedUser) {
        final AuthInfoEntity authInfoEntity = new AuthInfoEntity();
        authInfoEntity.setLogin(request.getLogin());
        authInfoEntity.setPassword(passwordEncoder.encode(request.getPassword()));
        authInfoEntity.setUserEntity(savedUser);
        authInfoRepository.save(authInfoEntity);
    }
}
