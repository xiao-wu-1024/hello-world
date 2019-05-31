package com.liu.dao;

import com.liu.entity.AdminUser;
import com.liu.entity.Landlord;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 吾嘉
 * @since 2019-05-14
 */
public interface LandlordMapper extends BaseMapper<Landlord> {

    @Select("select * from landlord where phone=#{phone}")
    List<Landlord> selectAll(Long phone);


    int insertLandlord(Landlord landlord);
}
