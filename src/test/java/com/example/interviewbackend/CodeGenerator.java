// 自动生成与数据库中所有表相关的四层框架代码
package com.example.interviewbackend;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

public class CodeGenerator {
    public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1:3306/interview?characterEncoding=utf8&serverTimezone=UTC";
        String username = "root";
        String password = "123456789";
        String moduleName = "interviewbackend";
        String mapperLocation = "D:\\1_AProjects\\IDEA_java\\interview-backend\\src\\main\\resources\\mapper\\"+moduleName;
        String tables = "user,tittle10,nature10";
        FastAutoGenerator.create(url, username, password)
                .globalConfig(builder -> {
                    builder.author("Jason") // 设置作者
                            //.enableSwagger() // 开启 swagger 模式
                            //.fileOverride() // 覆盖已生成文件
                            .outputDir("D:\\1_AProjects\\IDEA_java\\interview-backend\\src\\main\\java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.example") // 设置父包名
                            .moduleName(moduleName) // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, mapperLocation)); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude(tables) // 设置需要生成的表名
                            .addTablePrefix("t_", "c_", "x_"); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
