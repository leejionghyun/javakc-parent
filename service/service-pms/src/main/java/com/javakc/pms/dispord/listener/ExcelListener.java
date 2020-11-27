package com.javakc.pms.dispord.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.javakc.pms.dispord.entity.DispOrd;
import com.javakc.pms.dispord.service.DispOrdService;
import com.javakc.pms.dispord.vo.DispOrdData;
import org.springframework.beans.BeanUtils;

public class ExcelListener extends AnalysisEventListener<DispOrdData> {

    DispOrdService dispOrdService;
    public  ExcelListener(DispOrdService dispOrdService){
        this.dispOrdService = dispOrdService;
    }
    public ExcelListener(){

    }
    /**
     * 一行行读取数据时执行的方法
     * @param dispOrdData
     * @param analysisContext
     */
    @Override
    public void invoke(DispOrdData dispOrdData, AnalysisContext analysisContext) {
        // ## 创建一个实体
        DispOrd dispOrd =new DispOrd();
        // ## 复制
        BeanUtils.copyProperties(dispOrdData,dispOrd);
        // ## 保存
        dispOrdService.saveOrUpdate(dispOrd);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
