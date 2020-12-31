package cn.com.codingce.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/upload/**")   //表示文件路径，这里的意思是upload包下的所有文件
                //表示要开放的资源
                .addResourceLocations("file:"+System.getProperty("user.dir")+"/upload/");
    }

}