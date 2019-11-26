package com.briup.cms.web.controller;
import com.briup.cms.bean.Link;
import com.briup.cms.service.IlinkService;
import com.briup.cms.util.Message;
import com.briup.cms.util.MessageUtil;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("link")
@Api(description = "链接管理")

public class LinkController {
    @Autowired
    private IlinkService linkervice;
    @PostMapping("/add")
    @ApiOperation("添加链接")
   public Message addLink(Link link){
        linkervice.addLink(link);
        return  MessageUtil.success();
   }
   @GetMapping("/delete")
   @ApiOperation("删除链接")
   @ApiImplicitParam(name = "id",value = "链接id",paramType = "query",dataType = "int",required = true)
   public Message deleteLink(int id){
        linkervice.deleteLink(id);
        return  MessageUtil.success();


   }

   @GetMapping("find")
   @ApiOperation("寻找链接")
   @ApiImplicitParam(name = "id",value = "链接id",paramType = "query",dataType = "int",required = true)
    public Message findById(int id){
       Link link = linkervice.findById(id);
       return MessageUtil.success(link);

   }
    @PostMapping("/update")
    @ApiOperation("修改链接")
    public Message saveOrUpdate(Link link){
        linkervice.saveOrUpdate(link);
        return  MessageUtil.success();

    }
    @PostMapping("/findAll99")
    @ApiOperation("修改链接")
    public Message<List<Link>> findAll(){
        linkervice.findAllById();
        return MessageUtil.success();

    }

}