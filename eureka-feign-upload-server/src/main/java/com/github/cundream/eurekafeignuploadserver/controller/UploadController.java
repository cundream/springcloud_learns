package com.github.cundream.eurekafeignuploadserver.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @auther : lc
 * @Date: 2018/12/28 15:09
 * @Description:
 */
@RestController
public class UploadController {

    @PostMapping(value = "/uploadFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String handleFileUpload(@RequestPart(value = "file") MultipartFile file) {
        System.out.println("接收到了问卷-----------------"+ file.getName());
        return file.getName();
    }
}
