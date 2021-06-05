package com.example.redstoreapi.entity;

import com.example.redstoreapi.enums.ProductType;
import com.example.redstoreapi.enums.Tag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private double price;
    private String img;
    @Enumerated(value = EnumType.STRING)
    private ProductType type;
    @Enumerated(value = EnumType.STRING)
    private Tag tag;
    private int ratio;
    private int countAvailable;
    private String details;
}
