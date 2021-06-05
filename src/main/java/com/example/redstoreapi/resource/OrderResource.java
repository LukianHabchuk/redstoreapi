package com.example.redstoreapi.resource;

import com.example.redstoreapi.entity.Order;
import com.example.redstoreapi.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderResource {

    private final OrderService service;

    public OrderResource(OrderService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Order>> getAll() {
        var orders = service.getAll();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Order> getById(@PathVariable(name = "id") long id) {
        var order = service.getById(id);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @GetMapping("/find/user/{id}")
    public ResponseEntity<List<Order>> getByUserId(@PathVariable(name = "id") long id) {
        var order = service.getByUserId(id);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @GetMapping("/find/product/{id}")
    public ResponseEntity<List<Order>> getByProductId(@PathVariable(name = "id") long id) {
        var order = service.getByProductId(id);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Order> add(@RequestBody Order order) {
        var newOrder = service.create(order);
        return new ResponseEntity<>(newOrder, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Order> update(@RequestBody Order order) {
        var updateOrder = service.create(order);
        return new ResponseEntity<>(updateOrder, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") long id) {
        service.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
