package com.portfolioBack.Service.Implementation;

import com.portfolioBack.Service.PortFolioService;
import com.portfolioBack.entity.portfolio;
import com.portfolioBack.repo.PortfolioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortFolioServiceImplementation implements PortFolioService {


    final PortfolioRepo portfolioRepo;
    @Autowired
    public PortFolioServiceImplementation(PortfolioRepo portfolioRepo) {
        this.portfolioRepo = portfolioRepo;
    }

    @Override
    public List<portfolio> getAllData() {
        return portfolioRepo.findAll();
    }

    @Override
    public portfolio saveData(portfolio portfolio) {
        return portfolioRepo.save(portfolio);
    }

    @Override
    public portfolio getDataById(Long id) {
        return portfolioRepo.findById(id).get();
    }

    @Override
    public portfolio updateData(portfolio portfolio) {
        return portfolioRepo.save(portfolio);
    }

    @Override
    public void deleteDataById(Long id) {
        portfolioRepo.deleteById(id);

    }
}
