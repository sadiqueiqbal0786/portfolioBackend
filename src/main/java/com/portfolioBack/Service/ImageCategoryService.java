package com.portfolioBack.Service;

import com.portfolioBack.entity.ImageCategory;
import com.portfolioBack.entity.portfolio;

import java.util.List;

public interface ImageCategoryService {
    List<ImageCategory> getAllData();
    ImageCategory saveData(ImageCategory imageCategory);

    ImageCategory getDataById(Long id);

    ImageCategory updateData(ImageCategory imageCategory);

    void deleteDataById(Long id);

}
