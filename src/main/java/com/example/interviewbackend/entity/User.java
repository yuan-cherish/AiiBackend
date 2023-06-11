package com.example.interviewbackend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Jason
 * @since 2023-04-26
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    /**
     * 电话号码
     */
    private String userPhone;

    /**
     * 用户密码
     */
    private String password;
    private Integer score;
    private String nature;
    private String answerTime;

    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserPhone() {
        return userPhone;
    }
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getScore() {
        return score;
    }
    public void setScore(Integer score) {
        this.score = score;
    }

    public String getNature() {
        return nature;
    }
    public void setNature(String nature) {this.nature = nature;}

    public String  getAnswerTime() {
        return answerTime;
    }
    public void setAnswerTime(String answerTime) {this.answerTime = answerTime;}

    @Override
    public String toString() {
        return "User{" +
            "userId=" + userId +
            ", userPhone=" + userPhone +
            ", password=" + password +
            ", score=" + score +
            ", nature=" + nature +
            ", answerTime=" + answerTime +
        "}";
    }
}
