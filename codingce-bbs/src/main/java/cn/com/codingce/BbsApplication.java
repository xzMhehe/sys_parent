package cn.com.codingce;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>
 *  启动类
 * </p>
 *
 * @author Ma Xinze
 * @since 2021-1-1
 */
@SpringBootApplication
@MapperScan("cn.com.codingce.mapper")
public class BbsApplication {

    public static void main(String[] args) {
        SpringApplication.run(BbsApplication.class, args);
    }

}
