package com.usersPackage.Users.entity;

public enum Role {
    ADMIN,
    USER;

    public static Role fromString(String value) {
        return switch (value.toUpperCase()) {
            case "ADMIN"  -> ADMIN;
            case "admin" -> ADMIN;

            case "USER" -> USER;
            case "user" -> USER;

            default -> throw new IllegalArgumentException("Especificacion de ROL invalida: " + value);
        };
    }
}
