package com.briup.cms.service.Impl;

import com.briup.cms.bean.Article;
import com.briup.cms.dao.IArticleDao;
import com.briup.cms.exception.CustomerException;
import com.briup.cms.service.IArticleService;
import com.briup.cms.util.CodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ArticleServiceImpl implements IArticleService {
    @Autowired
    private IArticleDao iArticleDao;
    @Override
    public void addArticle(Article article) throws CustomerException {
        if(article==null){
            throw  new  CustomerException(CodeUtil.BAD_CODE,"参数错误");
        }
        article.setClickTimes(0);
        article.setPublishDate(new Date());
        iArticleDao.save(article);
    }

    @Override
    public void deleteArticle(int id) throws CustomerException {
        iArticleDao.deleteById(id);
    }

    @Override
    public Article findArticle(int id) throws CustomerException {
        return iArticleDao.queryById(id);
    }

    @Override
    public List<Article> findAll() throws CustomerException {
        return iArticleDao.findAll();
    }
}
