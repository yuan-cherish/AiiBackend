package com.example.interviewbackend.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.interviewbackend.controller.dto.ScoreDTO;
import com.example.interviewbackend.controller.dto.UserDTO;
import com.example.interviewbackend.mapper.UserMapper;
import com.example.interviewbackend.entity.User;
import com.example.interviewbackend.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Jason
 * @since 2023-04-26
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public boolean login(UserDTO userDTO) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        // 这是用于数据库查询的where条件，因此column名称应该与数据库中一样而非实体类中
        queryWrapper.eq("user_phone", userDTO.getUserPhone()).eq("password", userDTO.getPassword());
        try {
            User one = getOne(queryWrapper);    // getOne是获取一条记录，但是当数据库中存在多条相同的记录时也不应该登录，所以抛出异常
            return one != null;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean register(UserDTO userDTO) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        // 这是用于数据库查询的where条件，因此column名称应该与数据库中一样而非实体类中
        queryWrapper.eq("user_phone", userDTO.getUserPhone()).eq("password", userDTO.getPassword());
        User one = getOne(queryWrapper);
        if(one == null) {
            one = new User();
            BeanUtil.copyProperties(userDTO, one, true);
            save(one);
        } else {
            return false;
        }
        return true;
    }

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean saveScore(ScoreDTO scoreDTO) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_phone", scoreDTO.getUserPhone());
        User user = getOne(queryWrapper);
        if (user != null) {
            // 数据库中存在该用户，则将其分数存进该用户的score列
            user.setScore(scoreDTO.getScore());
            user.setNature(scoreDTO.getNature());
            user.setAnswerTime(scoreDTO.getAnswerTime());
            userMapper.updateById(user);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Integer getScore(String userPhone) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_phone", userPhone);
        User user = getOne(queryWrapper);
        if (user!=null && user.getScore()!=null) {
            return user.getScore();
        } else {
            return null;
        }
    }
}
