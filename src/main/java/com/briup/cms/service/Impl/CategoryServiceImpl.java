package com.briup.cms.service.Impl;

import com.briup.cms.bean.Category;
import com.briup.cms.bean.EX.CategoryEX;
import com.briup.cms.dao.EX.ICategoryEXDao;
import com.briup.cms.dao.ICategoryDao;
import com.briup.cms.exception.CustomerException;
import com.briup.cms.service.ICategoryService;
import com.briup.cms.util.CodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private ICategoryDao iCategoryDao;
    @Autowired
    private ICategoryEXDao iCategoryEXDao;
    @Override
    public void saveOrUpdateById(Category category) throws CustomerException {
        if(category == null){
            throw  new CustomerException(CodeUtil.BAD_CODE,"参数错误");
        }
        iCategoryDao.save(category);
    }

    @Override
    public void deleteCategory(int id) throws CustomerException {
           iCategoryDao.deleteById(id);
    }

    @Override
    public Category findCategoryById(int id) throws CustomerException {
        return iCategoryDao.queryById(id);
    }

    @Override
    public List<Category> findAll() throws CustomerException {
      return   iCategoryDao.findAll();
    }

    @Override
    public List<CategoryEX> findAllCategoryEX() throws CustomerException {
        return iCategoryEXDao.findAll();
    }
}
