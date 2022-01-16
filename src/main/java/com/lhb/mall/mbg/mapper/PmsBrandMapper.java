package com.lhb.mall.mbg.mapper;

import com.lhb.mall.mbg.model.PmsBrand;
import com.lhb.mall.mbg.model.PmsBrandExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PmsBrandMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_brand
     *
     * @mbggenerated Sun Jan 16 14:38:24 CST 2022
     */
    int countByExample(PmsBrandExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_brand
     *
     * @mbggenerated Sun Jan 16 14:38:24 CST 2022
     */
    int deleteByExample(PmsBrandExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_brand
     *
     * @mbggenerated Sun Jan 16 14:38:24 CST 2022
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_brand
     *
     * @mbggenerated Sun Jan 16 14:38:24 CST 2022
     */
    int insert(PmsBrand record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_brand
     *
     * @mbggenerated Sun Jan 16 14:38:24 CST 2022
     */
    int insertSelective(PmsBrand record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_brand
     *
     * @mbggenerated Sun Jan 16 14:38:24 CST 2022
     */
    List<PmsBrand> selectByExampleWithBLOBs(PmsBrandExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_brand
     *
     * @mbggenerated Sun Jan 16 14:38:24 CST 2022
     */
    List<PmsBrand> selectByExample(PmsBrandExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_brand
     *
     * @mbggenerated Sun Jan 16 14:38:24 CST 2022
     */
    PmsBrand selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_brand
     *
     * @mbggenerated Sun Jan 16 14:38:24 CST 2022
     */
    int updateByExampleSelective(@Param("record") PmsBrand record, @Param("example") PmsBrandExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_brand
     *
     * @mbggenerated Sun Jan 16 14:38:24 CST 2022
     */
    int updateByExampleWithBLOBs(@Param("record") PmsBrand record, @Param("example") PmsBrandExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_brand
     *
     * @mbggenerated Sun Jan 16 14:38:24 CST 2022
     */
    int updateByExample(@Param("record") PmsBrand record, @Param("example") PmsBrandExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_brand
     *
     * @mbggenerated Sun Jan 16 14:38:24 CST 2022
     */
    int updateByPrimaryKeySelective(PmsBrand record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_brand
     *
     * @mbggenerated Sun Jan 16 14:38:24 CST 2022
     */
    int updateByPrimaryKeyWithBLOBs(PmsBrand record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_brand
     *
     * @mbggenerated Sun Jan 16 14:38:24 CST 2022
     */
    int updateByPrimaryKey(PmsBrand record);
}