package com.briup.cms.web.controller;


import com.briup.cms.bean.Article;
import com.briup.cms.service.Impl.ArticleServiceImpl;
import com.briup.cms.util.Message;
import com.briup.cms.util.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/article")
@Api(description = "文章管理")

public class ArticleController {
    @Autowired
    private ArticleServiceImpl articleService;
    @PostMapping("/add")
    @ApiImplicitParam(name = "id",value = "文章内容",paramType = "query",dataType = "int",required = true)
    @ApiOperation(value = "新增文章",notes = "category.code category.name 不需要输入")
    public Message addArticle(Article article){
        articleService.addArticle(article);
        return MessageUtil.success();

 }
    @GetMapping("/delete")
    @ApiImplicitParam(name = "id",value = "文章删除",paramType = "query",dataType = "int",required = true)
    @ApiOperation("删除文章")
    public Message deleteArticle(int id){
        articleService.deleteArticle(id);
        return MessageUtil.success();

    }
    @GetMapping("/find")
    @ApiImplicitParam(name = "id",value = "文章寻找",paramType = "query",dataType = "int",required = true)
    @ApiOperation("寻找文章")
    public  Message<Article> findArticle(int id){
        Article article = articleService.findArticle(id);
        return  MessageUtil.success(article);


    }
    @GetMapping("/findAll")
    @ApiOperation("查询全部稳住")
    @ApiImplicitParam(name = "id",value = "寻找全部",paramType = "query",dataType = "int",required = true)
    public  Message<List<Article>> findAll(){
        List<Article> allArticle = articleService.findAll();
        return MessageUtil.success(allArticle);
    }

}
