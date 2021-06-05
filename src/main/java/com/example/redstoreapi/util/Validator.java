package com.example.redstoreapi.util;


import com.example.redstoreapi.dto.OrderDTO;

public class Validator {

    private Validator() {
    }

    public static boolean isValid(OrderDTO orderDTO) {
        return !orderDTO.getSize().isEmpty() && orderDTO.getCount() > 0;
    }
}
