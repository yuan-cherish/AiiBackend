package com.example.interviewbackend.service;

import com.example.interviewbackend.controller.dto.ScoreDTO;
import com.example.interviewbackend.controller.dto.UserDTO;
import com.example.interviewbackend.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Jason
 * @since 2023-04-26
 */
public interface IUserService extends IService<User> {

    boolean login(UserDTO userDTO);

    boolean register(UserDTO userDTO);

    boolean saveScore(ScoreDTO scoreDTO);

    Integer getScore(String userPhone);
}
