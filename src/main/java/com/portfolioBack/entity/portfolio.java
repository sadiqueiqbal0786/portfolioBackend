package com.portfolioBack.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "portfolio")
@Data
public class portfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "imageUrl")
    private String imageUrl;
    @ManyToOne
    @JoinColumn(name = "category_id",nullable = false)
    private ImageCategory category;

}
