package com.briup.cms.web.controller;

import com.briup.cms.bean.Category;
import com.briup.cms.service.ICategoryService;
import com.briup.cms.util.Message;
import com.briup.cms.util.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/index")
@Api(description = "首页管理")
public class IndexController {
    private ICategoryService categoryService;

    @GetMapping("/showIndex")
    @ApiOperation("首页数据")
    public Message<List<Category>> showIndex(){
        return MessageUtil.success(categoryService.findAll());

    }
}
