package com.example.interviewbackend;

import com.example.interviewbackend.entity.Tittle10;
import com.example.interviewbackend.mapper.Tittle10Mapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class InterviewBackendApplicationTests {

    @Resource
    private Tittle10Mapper tittle10Mapper;

    @Test
    void testMapper() {
        List<Tittle10> tittle10s = tittle10Mapper.selectList(null);
        tittle10s.forEach(System.out::println);
    }

}
