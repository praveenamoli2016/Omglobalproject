package com.omglobal.omglobal.model.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "Brands_Table")
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "brand_name")
    private String name;
}
