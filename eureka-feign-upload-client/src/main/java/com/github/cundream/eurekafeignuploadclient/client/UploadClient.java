package com.github.cundream.eurekafeignuploadclient.client;

import com.github.cundream.eurekafeignuploadclient.config.MultipartSupportConfig;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

/**
 * @auther: lc
 * @Date: 2018/12/28 15:18
 * @Description:
 */
@FeignClient(value = "eureka-feign-upload-server", configuration = MultipartSupportConfig.class)
public interface UploadClient {
    @PostMapping(value = "/uploadFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    String handleFileUpload(@RequestPart(value = "file") MultipartFile file);

}
