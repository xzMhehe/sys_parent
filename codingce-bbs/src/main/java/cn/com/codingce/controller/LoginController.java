package cn.com.codingce.controller;

import cn.com.codingce.pojo.Invite;
import cn.com.codingce.pojo.User;
import cn.com.codingce.pojo.UserInfo;
import cn.com.codingce.service.InviteService;
import cn.com.codingce.service.UserInfoService;
import cn.com.codingce.service.UserService;
import cn.com.codingce.utils.ZeUtils;
import cn.com.codingce.vo.RegisterForm;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * <p>
 *  Controller 控制层
 * </p>
 *
 * @author Ma Xinze
 * @since 2021-1-1
 */
@Controller
public class LoginController {

    @Autowired
    InviteService inviteService;

    @Autowired
    UserService userService;

    @Autowired
    UserInfoService userInfoService;

    @GetMapping("/toLogin")
    public String toLogin() {
        return "login";
    }


    // 注册业务
    @PostMapping("/register")
    public String register(RegisterForm registerForm, Model model) {
        ZeUtils.print("注册表单信息：" + registerForm.toString());
        // 表单密码重复判断
        if (!registerForm.getPassword().equals(registerForm.getRepassword())) {
            model.addAttribute("registerMsg", "密码输入有误");
            return "register";
        }
        // 用户名已存在
        User hasUser = userService.getOne(new QueryWrapper<User>().eq("username", registerForm.getUsername()));
        if (hasUser != null) {
            model.addAttribute("registerMsg", "用户名已存在");
            return "register";
        }

        // 验证邀请码
        Invite invite = inviteService.getOne(new QueryWrapper<Invite>().eq("code", registerForm.getCode()));
        if (invite == null) {
            model.addAttribute("registerMsg", "邀请码不存在");
            return "register";
        } else {
            // 邀请码存在，判断邀请码是否有效
            if (invite.getStatus() == 1) {
                model.addAttribute("registerMsg", "邀请码已被使用");
                return "register";
            } else {
                // 构建用户对象
                User user = new User();
                user.setUid(ZeUtils.getUuid()); // 用户唯一id
                user.setRoleId(2);
                user.setUsername(registerForm.getUsername());
                // 密码加密
                String bCryptPassword = new BCryptPasswordEncoder().encode(registerForm.getPassword());
                user.setPassword(bCryptPassword);
                user.setGmtCreate(ZeUtils.getTime());
                user.setLoginDate(ZeUtils.getTime());
                // 保存对象！
                userService.save(user);
                ZeUtils.print("新用户注册成功：" + user);

                // 激活邀请码
                invite.setActiveTime(ZeUtils.getTime());
                invite.setStatus(1);
                invite.setUid(user.getUid());
                inviteService.updateById(invite);

                // todo: 用户信息
                userInfoService.save(new UserInfo().setUid(user.getUid()));

                // 注册成功，重定向到登录页面
                return "redirect:/toLogin";
            }
        }
    }

}
