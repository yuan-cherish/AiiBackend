package com.example.interviewbackend.mapper;

import com.example.interviewbackend.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Jason
 * @since 2023-04-26
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
