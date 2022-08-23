package com.omglobal.omglobal.model.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "Category_Table")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Category_Id")
    private Long id;

    @Column(name = "Category_Name")
    private String name;

    @Column(name = "discription")
    private String discription;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "created_at")
    private String createdAt;

    @Column(name = "updated_at")
    private String updatedAt;

}
