package com.example.currency.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.FetchType.EAGER;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
@Component
@Entity
@Table(name = "Cube")
public class Cube {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @OneToMany(fetch = EAGER, cascade = {PERSIST, MERGE}, orphanRemoval = true, mappedBy = "cube")
    private List<Currency> currencies;
    @Column(name = "date")
    private LocalDate time;
}
