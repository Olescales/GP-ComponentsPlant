package com.example.componentsplant.mapper;

import com.example.componentsplant.dto.EmployeeSignUpRequest;
import com.example.componentsplant.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper (componentModel = "spring")
public interface EmployeeSingUpRequestMapper {

    UserEntity sourceToDestination (EmployeeSignUpRequest source);

    EmployeeSignUpRequest destinationToSource(UserEntity destination);

}
