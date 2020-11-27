package com.javakc.pms.dispord.vo;

import lombok.Data;

/**
 * 封装查询条件 - 调度指令库
 */
@Data
public class DispOrdQuery {

  private String orderName;
  private String beginDate;
  private String endDate;


}
