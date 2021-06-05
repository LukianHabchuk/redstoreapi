package com.example.redstoreapi.service;


import com.example.redstoreapi.dto.OrderDTO;
import com.example.redstoreapi.entity.Order;
import com.example.redstoreapi.exception.OrderNotFoundException;
import com.example.redstoreapi.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.redstoreapi.constants.Constants.ORDER_ATTRIBUTE;
import static com.example.redstoreapi.constants.Constants.WITH_WAS_NOT_FOUND;
import static com.example.redstoreapi.util.Validator.isValid;


@Service
public class OrderService {

    private final OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public Order create(Order order) {
        return repository.save(order);
    }

    public Order create(OrderDTO orderDTO, long userId) {
        return isValid(orderDTO) ? repository.save(new Order(userId, orderDTO.getProductId(),
                orderDTO.getSize(), orderDTO.getCount())) : null;
    }

    public void remove(long id) {
        repository.deleteById(id);
    }

    public List<Order> getAll() {
        return repository.findAll();
    }

    public Order getById(Long id) {
        return repository.findById(id).orElseThrow(() ->
                new OrderNotFoundException(String.format(WITH_WAS_NOT_FOUND, ORDER_ATTRIBUTE, "id", id)));
    }

    public List<Order> getByUserId(Long id) {
        return repository.findAllByUserId(id).orElseThrow(() ->
                new OrderNotFoundException(String.format(WITH_WAS_NOT_FOUND, ORDER_ATTRIBUTE, "user id", id)));
    }

    public List<Order> getByProductId(Long id) {
        return repository.findAllByProductId(id).orElseThrow(() ->
                new OrderNotFoundException(String.format(WITH_WAS_NOT_FOUND, ORDER_ATTRIBUTE, "product id", id)));
    }
}
