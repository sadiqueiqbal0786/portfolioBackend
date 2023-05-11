package com.portfolioBack.repo;

import com.portfolioBack.entity.ImageCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@CrossOrigin("http://localhost:3000")
@RepositoryRestResource(collectionResourceRel = "imageCategory",path="image-category")
public interface ImageCategoryRepo extends JpaRepository<ImageCategory,Long> {
}
