package com.portfolioBack.Service;

import com.portfolioBack.entity.portfolio;

import java.util.List;

public interface PortFolioService {
    List<portfolio> getAllData();
    portfolio saveData(portfolio portfolio);

    portfolio getDataById(Long id);

    portfolio updateData(portfolio portfolio);

    void deleteDataById(Long id);



}
