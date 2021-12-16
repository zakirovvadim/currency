package com.example.currency.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Component
@Table(name = "Currency")
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name = "currency")
    private String currency;
    @Column(name = "rate")
    private Double rate;
    @Column(name = "data")
    private LocalDate date;
}
