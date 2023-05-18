package com.portfolioBack.repo;

import com.portfolioBack.entity.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:3000")
public interface PortfolioRepo extends JpaRepository <Portfolio,Long>{

}
