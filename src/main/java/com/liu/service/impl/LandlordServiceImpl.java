package com.liu.service.impl;

import com.liu.entity.Landlord;
import com.liu.dao.LandlordMapper;
import com.liu.service.LandlordService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 吾嘉
 * @since 2019-05-14
 */
@Service
public class LandlordServiceImpl extends ServiceImpl<LandlordMapper, Landlord> implements LandlordService {

    @Autowired
    LandlordMapper landlordMapper;

    @Override
    public List<Landlord> selectAll(Long phone) {
        return landlordMapper.selectAll(phone);
    }

    @Override
    public int insertLandlord(Landlord landlord) {
        return landlordMapper.insertLandlord(landlord);
    }
}
