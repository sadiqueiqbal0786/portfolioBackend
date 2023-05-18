package com.portfolioBack.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.util.Set;
@Entity
@Table(name = "image_category")
@Getter
@Setter
public class ImageCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "image_name")
    private String imageName;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "category")
    private Set<Portfolio> portfolio;

}
