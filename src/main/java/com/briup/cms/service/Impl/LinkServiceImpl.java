package com.briup.cms.service.Impl;

import com.briup.cms.bean.Link;
import com.briup.cms.dao.ILinkDao;
import com.briup.cms.exception.CustomerException;
import com.briup.cms.service.IlinkService;
import com.briup.cms.util.CodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkServiceImpl implements IlinkService {
    @Autowired
    private ILinkDao iLinkDao;

    @Override
    public void addLink(Link link) throws CustomerException {
        if(link == null){
            throw  new CustomerException(CodeUtil.BAD_CODE,"出错了");
        }
            iLinkDao.save(link);

    }
}
