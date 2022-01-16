package com.lhb.mall.controller;

import com.github.pagehelper.Page;
import com.lhb.mall.common.api.CommonPage;
import com.lhb.mall.common.api.CommonResult;
import com.lhb.mall.mbg.model.PmsBrand;
import com.lhb.mall.service.PmsBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author lhb
 * @date 2022/1/16 16:51
 */

@RequestMapping("brand")
@RestController
public class PmsBrandController {

    @Autowired
    private PmsBrandService brandService;

    @GetMapping("listAll")
    public CommonResult<List<PmsBrand>> getAll() {
        List<PmsBrand> brands = brandService.listAllBrand();
        return CommonResult.success(brands);
    }

    @GetMapping("list")
    public CommonResult<CommonPage<PmsBrand>> getList(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                               @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        List<PmsBrand> brands = brandService.listBrand(pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(brands));
    }

    @GetMapping("info/{id}")
    public CommonResult<PmsBrand> getInfo(@PathVariable("id") Long id) {
        PmsBrand brand = brandService.infoBrand(id);
        return CommonResult.success(brand);
    }

    @PostMapping("create")
    public CommonResult create(@RequestBody PmsBrand pmsBrand) {
        int result = brandService.createBrand(pmsBrand);
        if (result == 1){
            return CommonResult.success(null);
        } else {
            return CommonResult.failed("创建失败");
        }
    }

    @GetMapping("delete/{id}")
    public CommonResult delete(@PathVariable Long id) {
        int result = brandService.deleteBrand(id);
        if (result == 1) {
            return CommonResult.success(null);
        } else  {
            return CommonResult.failed("删除失败");
        }
    }

    @PostMapping("update/{id}")
    public CommonResult update(@PathVariable("id") Long id, @RequestBody PmsBrand pmsBrand) {
        int result = brandService.updateBrand(id, pmsBrand);
        if (result == 1) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed("更新失败");
        }
    }
}
