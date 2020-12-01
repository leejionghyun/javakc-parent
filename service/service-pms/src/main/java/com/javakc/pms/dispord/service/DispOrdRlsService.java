package com.javakc.pms.dispord.service;

import com.javakc.commonutils.jpa.base.service.BaseService;
import com.javakc.commonutils.jpa.dynamic.SimpleSpecificationBuilder;
import com.javakc.pms.dispord.dao.DispOrdRlsDao;
import com.javakc.pms.dispord.entity.DispOrdRls;
import com.javakc.pms.dispord.vo.DispOrdRlsQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class DispOrdRlsService extends BaseService<DispOrdRlsDao, DispOrdRls> {

    /**
     * 带条件的分页查询
     * @param dispOrdRlsQuery
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Page<DispOrdRls> findPageDispOrdRls(DispOrdRlsQuery dispOrdRlsQuery,int pageNum ,int pageSize){

        SimpleSpecificationBuilder<DispOrdRls> simpleSpecificationBuilder =new SimpleSpecificationBuilder();
        Page page=dao.findAll(simpleSpecificationBuilder.getSpecification(), PageRequest.of(pageNum - 1,pageSize));
        return page;
    }
}
