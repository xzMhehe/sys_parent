package cn.com.codingce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * <p>
 *  Controller 控制层
 * </p>
 *
 * @author Ma Xinze
 * @since 2021-1-1
 */
@Controller
public class UserController {
    @GetMapping({"/", "/main"})
    public String main() {
        return "main";
    }
}
