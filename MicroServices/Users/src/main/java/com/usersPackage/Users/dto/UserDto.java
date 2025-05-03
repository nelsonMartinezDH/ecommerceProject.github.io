package com.usersPackage.Users.dto;

public record UserDto(
        Long id,
        String username,
        String password,
        String email,
        String firstName,
        String lastName
) {
}
