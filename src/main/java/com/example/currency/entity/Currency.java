package com.example.currency.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.HashMap;

@Data
@Entity
@Component
@Table(name = "Currency")
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "currency")
    private String currencies;
    @Column(name = "rate")
    private Double rate;

    @ManyToOne
    @JsonManagedReference
    @Nullable
    @JoinTable(
            name = "cube_currencies", joinColumns = @JoinColumn(name = "cur_id"),
            inverseJoinColumns = @JoinColumn(name = "cube_id")
    )
    private Cube cube;

//    @Column(name = "currency")
//    private String currency;
//    @Column(name = "rate")
//    private Double rate;
}
