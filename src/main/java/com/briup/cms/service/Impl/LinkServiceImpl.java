package com.briup.cms.service.Impl;

import com.briup.cms.bean.Link;
import com.briup.cms.dao.ILinkDao;
import com.briup.cms.exception.CustomerException;
import com.briup.cms.service.IlinkService;
import com.briup.cms.util.CodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LinkServiceImpl implements IlinkService {
    @Autowired
    private ILinkDao iLinkDao;

    @Override
    public void addLink(Link link) throws CustomerException {

            if (link == null) {
                throw new CustomerException(CodeUtil.BAD_CODE, "出错了");
            }
            iLinkDao.save(link);
        }


    @Override
    public void deleteLink(int id) throws CustomerException {
        iLinkDao.deleteById(id);

    }

    @Override
    public Link findById(int id) throws CustomerException {
        return iLinkDao.queryByid(id);
    }

    @Override
    public void saveOrUpdate(Link link) throws CustomerException {

        if (link == null) {
            throw new CustomerException(CodeUtil.BAD_CODE, "出错了");
        }
        iLinkDao.save(link);
     }

    @Override
    public List<Link> findAllById() throws CustomerException {
        return iLinkDao.findAll();
    }
}



