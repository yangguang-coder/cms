package com.briup.cms.web.controller;

import com.briup.cms.bean.Category;
import com.briup.cms.bean.Link;
import com.briup.cms.dao.ICategoryDao;
import com.briup.cms.service.ICategoryService;
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
@RequestMapping
@Api(description = "栏目管理")
public class CategoryController {
    @Autowired
    private ICategoryService iCategoryService;
    @PostMapping("/save")
    @ApiOperation("保存或者更新")
    public Message saveOrUpdate(Category category){
        iCategoryService.saveOrUpdateById(category);
        return MessageUtil.success();
    }
    @GetMapping("find")
    @ApiOperation("查询")
    @ApiImplicitParam(name = "id",value = "链接id",paramType = "query",dataType = "int",required = true)
    public  Message<Category> findCategoryByid(int id){
        Category category = iCategoryService.findCategoryById(id);
        return  MessageUtil.success(category);

    }
    @GetMapping("/delete")
    @ApiOperation("删除")
    @ApiImplicitParam(name = "id",value = "链接id",paramType = "query",dataType = "int",required = true)
    public Message deleteCategory(int id){
        iCategoryService.deleteCategory(id);
        return  MessageUtil.success();

    }
    @GetMapping("/findAll")
    @ApiOperation("查找全部")
    @ApiImplicitParam()
    public Message<List<Category>> findAll(){
        iCategoryService.findAll();
        return MessageUtil.success();
    }



}
