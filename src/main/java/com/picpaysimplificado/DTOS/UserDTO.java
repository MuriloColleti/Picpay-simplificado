package com.picpaysimplificado.DTOS;

import com.picpaysimplificado.domain.user.UserType;

import java.math.BigDecimal;

public record UserDTO(String firtName, String email, String document, String lastName, BigDecimal Balance, UserType userType, String passoword) {
}
