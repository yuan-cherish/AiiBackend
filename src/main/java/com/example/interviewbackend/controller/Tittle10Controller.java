package com.example.interviewbackend.controller;

import com.example.interviewbackend.entity.Tittle10;
import com.example.interviewbackend.mapper.Tittle10Mapper;
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
@RequestMapping("/tittle10")
public class Tittle10Controller {

    @Autowired
    private Tittle10Mapper tittle10Mapper;

    // 查询所有题目
    @GetMapping("/all")
    public Map<String, Object> getAllTittle10() {
        List<Tittle10> data = tittle10Mapper.selectList(null);
        Long total = tittle10Mapper.selectCount(null);
        Map<String, Object> res = new HashMap<>();
        res.put("data", data);
        res.put("total", total);
        return res;
    }
}
