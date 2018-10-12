package com.example.demo.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping
public class FileUploadContraller {

    @RequestMapping("/fileuploadConaller")
    public Map<String, Object> fileUpload(MultipartFile filename) throws IOException {
        System.out.println(filename.getOriginalFilename());

        File file = new File("/Users/qingyun/JAVA-LEARN/uploads/" + filename.getOriginalFilename());
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        filename.transferTo(file);
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("mag", "ok");
        return stringObjectHashMap;
    }

}
