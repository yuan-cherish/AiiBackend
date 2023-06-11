package com.example.interviewbackend.controller;

import com.example.interviewbackend.entity.Nature10;
import com.example.interviewbackend.entity.Tittle10;
import com.example.interviewbackend.mapper.Nature10Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Jason
 * @since 2023-04-26
 */
@RestController
@RequestMapping("/nature10")
public class Nature10Controller {

    @Autowired
    private Nature10Mapper nature10Mapper;

    @GetMapping("/all")
    public Map<String, Object> getAllNature10() {
        List<Nature10> data = nature10Mapper.selectList(null);
        Long total = nature10Mapper.selectCount(null);
        Map<String, Object> res = new HashMap<>();
        res.put("data", data);
        res.put("total", total);
        return res;
    }
}
