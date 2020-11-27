package com.javakc.pms.dispord.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import javax.persistence.Column;

/**
 * 封装表头属性
 * @author leejionghyun
 * @version  1.0
 *
 */
@Data
public class DispOrdData {

    @ExcelProperty(value = "指令名称", index = 0)
    private String orderName;

    @ExcelProperty(value = "指令类型",index = 1)
    private int specType;

    @ExcelProperty(value = "优先级",index = 2)
    private int priority;

    @ExcelProperty(value = "指令描述",index = 3)
    private String orderDesc;
}
