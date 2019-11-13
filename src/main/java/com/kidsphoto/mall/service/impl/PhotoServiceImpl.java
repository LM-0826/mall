package com.kidsphoto.mall.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import com.kidsphoto.mall.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;

/**
 * @author 李明
 * @create 2019-11-13 13:35
 */
@Service
public class PhotoServiceImpl implements PhotoService {

    @Autowired
    private Environment environment;

    @Override
    public void uploadFile(MultipartFile file) {
        String endpoint = environment.getProperty("OSSWeb.endPoint");
        String accessKeyId = environment.getProperty("ossWeb.accessId");
        String accessKeySecret = environment.getProperty("ossWeb.accessKey");
        String bucketName = environment.getProperty("ossWeb.bucketName");
        String objectName = "image/" + file.getOriginalFilename();
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
       try {
           File newFile = new File(file.getName());
           FileOutputStream os = new FileOutputStream(newFile);
           os.write(file.getBytes());
           os.close();
           file.transferTo(newFile);
           PutObjectResult putObjectResult = ossClient.putObject(new PutObjectRequest(bucketName, objectName, newFile));
           System.out.println("========================" + putObjectResult.toString());
           ossClient.shutdown();
       } catch (Exception e) {
           e.printStackTrace();

       }

    }
}
