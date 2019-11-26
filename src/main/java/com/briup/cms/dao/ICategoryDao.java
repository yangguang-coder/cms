package com.briup.cms.dao;

import com.briup.cms.bean.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryDao extends JpaRepository<Category,Integer> {
    Category queryById( int id);
}
