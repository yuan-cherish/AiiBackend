package com.example.interviewbackend.controller;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@RestController
@RequestMapping("/files")
public class VideoController {

    @GetMapping("/{fileName:.+}")
    public ResponseEntity<Resource> getVideo(@PathVariable String fileName) {
        String basePath = "C:/Users/86159/Downloads/";
        String filePath = basePath + fileName;

        File file = new File(filePath);
        if (file.exists()) {
            Resource resource = new FileSystemResource(file);
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .contentLength(file.length())
                    .body(resource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/upload")
    public ResponseEntity<String> saveVideo(@RequestParam("userPhone") String userPhone,
                                            @RequestParam("currQuesNum") int currQuesNum,
                                            @RequestParam("video") MultipartFile video) {
        if (ObjectUtils.isEmpty(userPhone) || ObjectUtils.isEmpty(video)) {
            return ResponseEntity.badRequest().body("请求数据缺失！");
        }
        String targetRootPath = "D:/1_AProjects/IDEA_java/interview-backend/interview/src/output/";
        String targetUserPath = targetRootPath + userPhone;
        String targetPath = targetUserPath + "/" + currQuesNum + ".mp4";
        try {
            createFolderIfNotExists(targetUserPath);          // 用户文件夹不存在则先创建
            Files.copy(video.getInputStream(), Paths.get(targetPath), StandardCopyOption.REPLACE_EXISTING);
            return ResponseEntity.ok("视频保存成功！");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("视频保存失败！");
        }
    }

    private void createFolderIfNotExists(String folderPath) throws IOException {
        Path path = Paths.get(folderPath);
        if(!Files.exists(path)) {
            Files.createDirectories(path);
        }
    }
}
