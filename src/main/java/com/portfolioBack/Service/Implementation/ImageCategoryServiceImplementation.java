package com.portfolioBack.Service.Implementation;

import com.portfolioBack.Service.ImageCategoryService;
import com.portfolioBack.entity.ImageCategory;
import com.portfolioBack.repo.ImageCategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ImageCategoryServiceImplementation implements ImageCategoryService {
    final ImageCategoryRepo imageCategoryRepo;
@Autowired
    public ImageCategoryServiceImplementation(ImageCategoryRepo imageCategoryRepo) {
        this.imageCategoryRepo = imageCategoryRepo;
    }

    @Override
    public List<ImageCategory> getAllData() {
        return imageCategoryRepo.findAll();
    }

    @Override
    public ImageCategory saveData(ImageCategory imageCategory) {
        return imageCategoryRepo.save(imageCategory);
    }

    @Override
    public ImageCategory getDataById(Long id) {
        return imageCategoryRepo.findById(id).get();
    }

    @Override
    public ImageCategory updateData(ImageCategory imageCategory) {
        return imageCategoryRepo.save(imageCategory);
    }

    @Override
    public void deleteDataById(Long id) {
             imageCategoryRepo.deleteById(id);
    }
}
