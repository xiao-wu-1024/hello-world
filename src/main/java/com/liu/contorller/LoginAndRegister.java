package com.liu.contorller;

import com.liu.entity.Landlord;
import com.liu.entity.Tenant;
import com.liu.service.LandlordService;
import com.liu.service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/LoginAndRegister")
public class LoginAndRegister {

    @Autowired
    LandlordService landlordService;
    @Autowired
    TenantService tenantService;

    @RequestMapping("/login")   //登录页
    public String login(){
        return "login";
    }

    @ResponseBody
    @RequestMapping("/addUser")
    public String addUser(Landlord landlord, Tenant tenant,@RequestParam(value = "condition",required = true,defaultValue = "注册失败") String condition){
        System.out.println("注册身份:"+condition+"\n"+landlord.toString());
        if (condition.equals("业主")){
            List<Landlord> landlordList = landlordService.selectAll(landlord.getPhone());
            System.out.println(landlordList.toString());
            if(landlordList.size()==0){
                landlord.setRegisterDate(new Date());
                landlord.setUpdateDate(new Date());
                landlordService.insert(landlord);
                return "注册成功";
            }else {
                return "该手机已被注册";
            }
        }else if (condition.equals("房客")){
            Tenant tenant1 = tenantService.selectById(tenant);
            System.out.println(tenant1.toString());
            if (tenant1.getIdCard() != 0){
                return "该手机已被注册";
            }
            return "注册成功";
        }else {
            return "提交空值";
        }
    }

    @GetMapping("/toLogin")   //登录方法
    public String toLogin(){
        return "";
    }


    /*@RequestMapping("register")
    public String register(Landlord landlord, Admin admin, Tenant tenant, @RequestParam(value = "condition",required = true,defaultValue = "房客")String condition){
        System.out.println("注册身份："+condition);
        if (condition.equals("业主")){
            System.out.println("这是业主注册"+landlord.toString());
            return "login";
        }else if (condition.equals("admin")){
            System.out.println("管理员注册"+admin.toString());
            return "login";
        }else {
//            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            Date date=new Date();
            System.out.println("时间："+date);
            admin.setAddTime(date);
            System.out.println("这是房客注册"+tenant.toString());

            return "login";
        }
    }*/
}
