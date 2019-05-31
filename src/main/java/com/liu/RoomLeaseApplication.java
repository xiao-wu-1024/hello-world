package com.liu;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@Controller
@SpringBootApplication
@Configuration
@MapperScan("com.liu.dao")
public class RoomLeaseApplication {

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(RoomLeaseApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(RoomLeaseApplication.class, args);
        logger.info("\n"+
                " * ┏┓　　　┏┓\n" +
                " * ┏┛┻━━━┛┻┓\n" +
                " * ┃　　　　　　　┃\n" +
                " * ┃　　　━　　　┃\n" +
                " * ┃　┳┛　┗┳　┃\n" +
                " * ┃　　　　　　　┃\n" +
                " * ┃　　　┻　　　┃\n" +
                " * ┃　　　　　　　┃\n" +
                " * ┗━┓　　　┏━┛\n" +
                " * 　　┃　　　┃神兽保佑\n" +
                " * 　　┃　　　┃代码无BUG！\n" +
                " * 　　┃　　　┗━━━┓\n" +
                " * 　　┃　　　　　　　┣┓\n" +
                " * 　　┃　　　　　　　┏┛\n" +
                " * 　　┗┓┓┏━┳┓┏┛\n" +
                " * 　　　┃┫┫　┃┫┫\n" +
                " * 　　　┗┻┛　┗┻┛");

    }

    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }

    @RequestMapping("login")
    public String index(){
        System.out.println("登录");
        return "login";
    }

    @ResponseBody
    @RequestMapping("skip")
    public String skip(@RequestParam(value="skip", required=true, defaultValue="zhang") String skip ){

        System.out.println("跳转值"+skip);
        if (skip.equals("index")){
            return "首页";
        }else if (skip.equals("text")){
            return "测试";
        }else {
            return "没有值";
        }
    }
}
