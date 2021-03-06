package cn.com.codingce.service.impl;

import cn.com.codingce.mapper.UserMapper;
import cn.com.codingce.pojo.User;
import cn.com.codingce.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务类实现类
 * </p>
 *
 * @author Ma Xinze
 * @since 2021-1-1
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
