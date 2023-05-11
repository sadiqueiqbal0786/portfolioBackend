package com.portfolioBack.controller;

import com.portfolioBack.Service.ImageCategoryService;
import com.portfolioBack.entity.ImageCategory;
import com.portfolioBack.repo.ImageCategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class ImageCategoryController {
    @Autowired
    private ImageCategoryRepo imageCategoryRepo;

    // get all employees
    @GetMapping("/images")
    public List<ImageCategory> getAllCategory(){
        return imageCategoryRepo.findAll();
    }

    // create employee rest api
    @PostMapping("/images")
    public ImageCategory insertImage(@RequestBody ImageCategory imageCategory) {
        return imageCategoryRepo.save(imageCategory);
    }

    // get employee by id rest api
    @GetMapping("/images/{id}")
    public ResponseEntity<ImageCategory> getImageById(@PathVariable Long id) {
        ImageCategory imageCategory = imageCategoryRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Image not exist with id :" + id));
        return ResponseEntity.ok(imageCategory);
    }

    // update employee rest api

    @PutMapping("/images/{id}")
    public ResponseEntity<ImageCategory> updateImage(@PathVariable Long id, @RequestBody ImageCategory imageCategory){
        ImageCategory image = imageCategoryRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("image not exist with id :" + id));

        image.setImageName(imageCategory.getImageName());
        image.setPortfolio(imageCategory.getPortfolio());
        ImageCategory updateImage = imageCategoryRepo.save(image);
        return ResponseEntity.ok(updateImage);
    }

    // delete employee rest api
    @DeleteMapping("/images/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteImage(@PathVariable Long id){
        ImageCategory imageCategory = imageCategoryRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Image not exist with id :" + id));

        imageCategoryRepo.delete(imageCategory);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}

