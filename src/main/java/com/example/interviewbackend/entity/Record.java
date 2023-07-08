package com.example.interviewbackend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: Yuan
 * @Date: 2023/7/7 11:12
 */
@Data
@ToString
public class Record implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "record_id", type = IdType.AUTO)
    private Integer recordId;

    private Integer userId;
    private double score;
    private String path;
    private Date date;
}
