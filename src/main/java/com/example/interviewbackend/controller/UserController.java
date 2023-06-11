package com.example.interviewbackend.controller;

import cn.hutool.core.util.StrUtil;
import com.example.interviewbackend.controller.dto.ScoreDTO;
import com.example.interviewbackend.controller.dto.UserDTO;
import com.example.interviewbackend.service.IUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Jason
 * @since 2023-04-26
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService userService;

    @PostMapping("/login")   // 使用相同PostMapping注解时需要用路由去区分不同的post
    public boolean login(@RequestBody UserDTO userDTO) {
        String userPhone = userDTO.getUserPhone();
        String password = userDTO.getPassword();
        if (StrUtil.isBlank(userPhone) || StrUtil.isBlank(password)) {
            return false;
        }
        return userService.login(userDTO);
    }

    @PostMapping("/register")   // 使用相同PostMapping注解时需要用路由去区分不同的post
    public boolean register(@RequestBody UserDTO userDTO) {
        String userPhone = userDTO.getUserPhone();
        String password = userDTO.getPassword();
        if (StrUtil.isBlank(userPhone) || StrUtil.isBlank(password)) {
            return false;
        }
        return userService.register(userDTO);
    }

    @PostMapping("/saveScore")
    public boolean saveScore(@RequestBody ScoreDTO scoreDTO) {
        return userService.saveScore(scoreDTO);
    }

    @PostMapping("/getScore")
    public ResponseEntity<Integer> getScore(@RequestParam String userPhone) {
        Integer score = userService.getScore(userPhone);
        if(score!=null){
            return ResponseEntity.ok(score);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
