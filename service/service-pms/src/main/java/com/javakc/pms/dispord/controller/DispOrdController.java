package com.javakc.pms.dispord.controller;

import com.javakc.commonutils.api.APICODE;
import com.javakc.pms.dispord.entity.DispOrd;
import com.javakc.pms.dispord.service.DispOrdService;
import com.javakc.pms.dispord.vo.DispOrdQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "调度指令库控制器")
@RestController
@RequestMapping("/pms/dispord")
public class DispOrdController {
    @Autowired
    private DispOrdService dispOrdService;

    @ApiOperation("查询所有调度指令库数据")
    @GetMapping
    public APICODE findAll(){
        List<DispOrd> list=dispOrdService.findAll();
        return APICODE.OK().data("items",list);
    }

    @ApiOperation(value = "根据条件进行分页查询 - 调度指令库")
    @PostMapping("{pageNum}/{pageSize}")
    public APICODE findPageDispOrd(DispOrdQuery dispOrdQuery,@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize) {
        Page<DispOrd> page = dispOrdService.findPageDispOrd(dispOrdQuery, pageNum, pageSize);
        //总条数
        long totalElements = page.getTotalElements();
        //当前页的数据集合
        List<DispOrd> dispOrdList = page.getContent();
        return APICODE.OK().data("total", totalElements).data("items", dispOrdList);
    }

    @ApiOperation("新增 - 调度指令库")
    @PostMapping("creteDispOrd")
    public APICODE saveDispOrd(@RequestBody DispOrd dispOrd) {
        dispOrdService.saveOrUpdate(dispOrd);
        return APICODE.OK();
    }

        @ApiOperation(value = "根据调度指令库ID获取单条数据")
        @GetMapping("{dispOrdId}")
        public APICODE getDispOrdById(@PathVariable(name = "dispOrdId") String dispOrdId) {
            DispOrd dispOrd = dispOrdService.getById(dispOrdId);
            return APICODE.OK().data("dispOrd", dispOrd);
        }
    @ApiOperation(value = "修改 - 调度指令库")
    @PutMapping("updateDispOrd")
    public APICODE updateDispOrd(@RequestBody DispOrd dispOrd) {
        dispOrdService.saveOrUpdate(dispOrd);
        return APICODE.OK();
    }

    @ApiOperation(value = "删除 - 调度指令库")
    @DeleteMapping("{dispOrdId}")
    public APICODE deleteDispOrdById(@PathVariable(name = "dispOrdId") String dispOrdId) {
        dispOrdService.removeById(dispOrdId);
        return APICODE.OK();
    }
}

