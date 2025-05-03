package com.ordersPackage.Orders.entity;

public enum OrderState {
    PENDIENTE,
    ENVIADO,
    ENTREGADO;

    public static OrderState fromString(String value) {
        return switch (value.toUpperCase()) {
            case "PENDIENTE"  -> PENDIENTE;
            case "pendiente" -> PENDIENTE;

            case "ENVIADO" -> ENVIADO;
            case "enviado" -> ENVIADO;

            case "ENTREGADO" -> ENTREGADO;
            case "entregado" -> ENTREGADO;
            default -> throw new IllegalArgumentException("Estado del pedido inválido: " + value);
        };
    }
}
