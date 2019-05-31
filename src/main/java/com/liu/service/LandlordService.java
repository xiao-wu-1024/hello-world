package com.liu.service;

import com.liu.entity.Landlord;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 吾嘉
 * @since 2019-05-14
 */
public interface LandlordService extends IService<Landlord> {
    List<Landlord> selectAll(Long phone);

    int insertLandlord(Landlord landlord);
}
