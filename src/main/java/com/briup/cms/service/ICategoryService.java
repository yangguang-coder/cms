package com.briup.cms.service;

import com.briup.cms.bean.Category;
import com.briup.cms.bean.EX.CategoryEX;
import com.briup.cms.exception.CustomerException;

import java.util.List;

public interface ICategoryService {
    void saveOrUpdateById(Category category) throws CustomerException;
    void deleteCategory(int id) throws  CustomerException;
    Category findCategoryById(int id) throws  CustomerException;
    List<Category> findAll() throws CustomerException;
    List<CategoryEX> findAllCategoryEX() throws  CustomerException;
}

