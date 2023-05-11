package com.portfolioBack.controller;

import com.portfolioBack.entity.ImageCategory;

import com.portfolioBack.entity.portfolio;
import com.portfolioBack.repo.PortfolioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v2/")
public class PortfolioController {
    @Autowired
    private PortfolioRepo portfolioRepo;

    // get all employees
    @GetMapping("/portfolio")
    public List<portfolio> getAllDetails(){
        return portfolioRepo.findAll();
    }

    // create employee rest api
    @PostMapping("/portfolio")
    public portfolio insertDetails(@RequestBody portfolio portfolio) {
        return portfolioRepo.save(portfolio);
    }

    // get employee by id rest api
    @GetMapping("/portfolio/{id}")
    public ResponseEntity<portfolio> getDetailsById(@PathVariable Long id) {
        portfolio portfolio = portfolioRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Details not exist with id :" + id));
        return ResponseEntity.ok(portfolio);
    }

    // update employee rest api

    @PutMapping("/portfolio/{id}")
    public ResponseEntity<portfolio> updateDetails(@PathVariable Long id, @RequestBody portfolio portfolio){
        portfolio detail = portfolioRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("details not exist with id :" + id));

        detail.setName(portfolio.getName());
        detail.setDescription(portfolio.getDescription());
        detail.setImageUrl(portfolio.getImageUrl());
        detail.setCategory(portfolio.getCategory());

        portfolio updateDetail = portfolioRepo.save(detail);
        return ResponseEntity.ok(updateDetail);
    }

    // delete employee rest api
    @DeleteMapping("/portfolio/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteDetails(@PathVariable Long id){
        portfolio portfolio = portfolioRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Details not exist with id :" + id));

        portfolioRepo.delete(portfolio);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
