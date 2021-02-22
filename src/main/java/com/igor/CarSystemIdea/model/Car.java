package com.igor.CarSystemIdea.model;

import com.igor.CarSystemIdea.enums.CarColor;
import com.igor.CarSystemIdea.enums.CarType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(schema = "public", name = "car")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;

    @Column(name = "NUMBER")
    private String number;

    @Column(name = "COLOR")
    @Enumerated(EnumType.STRING)
    private CarColor color;

    @Column(name = "TYPE")
    @Enumerated(EnumType.STRING)
    private CarType type;

    @Column(name = "AMOUNT")
    private int amount;

    @Column(name = "PRICE")
    private double price;

    @Column(name = "IMAGE")
    private String image;
}
