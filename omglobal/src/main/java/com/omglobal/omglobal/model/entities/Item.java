package com.omglobal.omglobal.model.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "Items_Table")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "item_name")
    private String name;

    @Column(name = "item_code")
    private String itemCode;

    @Column(name = "bar_code")
    private String barCode;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price")
    private Long price;

    @Column(name = "discount")
    private String discount;

    @Column(name = "discount_type")
    private String discountType;

    @Column(name = "tax")
    private String tax;

    @Column(name = "tax_type")
    private String taxType;

    @Column(name = "sub_total")
    private String subTotal;

    @Column(name = "discription")
    private String discription;

    @Column(name = "created_at")
    private String createdAt;

    @Column(name = "updated_at")
    private String updatedAt;

}
