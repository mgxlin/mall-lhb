package com.lhb.mall.service;

import com.lhb.mall.mbg.model.PmsBrand;

import java.util.List;

/**
 * @author lhb
 * @date 2022/1/16 16:37
 */
public interface PmsBrandService {
    /**
     * 查询所有品牌
     */
    List<PmsBrand> listAllBrand();

    /**
     * 分页查询品牌
     */
    List<PmsBrand> listBrand(int pageNum, int pageSize);

    /**
     * 查询品牌详情
     */
    PmsBrand infoBrand(Long id);

    /**
     * 创建品牌
     */
    int createBrand(PmsBrand pmsBrand);

    /**
     * 删除品牌
     */
    int deleteBrand(Long id);

    /**
     * 更新品牌
     */
    int updateBrand(Long id, PmsBrand pmsBrand);
}
