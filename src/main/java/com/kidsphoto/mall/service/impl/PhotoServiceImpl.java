package com.kidsphoto.mall.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import com.kidsphoto.mall.dao.PhotoRepository;
import com.kidsphoto.mall.dao.UserRepository;
import com.kidsphoto.mall.entity.Photo;
import com.kidsphoto.mall.entity.User;
import com.kidsphoto.mall.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * @author 李明
 * @create 2019-11-13 13:35
 */
@Service
public class PhotoServiceImpl implements PhotoService {

    @Autowired
    private Environment environment;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PhotoRepository photoRepository;


    @Override
    public String uploadFile(File file, String name) {
        String endpoint = environment.getProperty("OSSWeb.endPoint");
        String accessKeyId = environment.getProperty("ossWeb.accessId");
        String accessKeySecret = environment.getProperty("ossWeb.accessKey");
        String bucketName = environment.getProperty("ossWeb.bucketName");
        String objectName = "image/" + name + file.getName();
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
       try {

           PutObjectResult putObjectResult = ossClient.putObject(new PutObjectRequest(bucketName, objectName, file));
           // 获取图片在阿里云上的链接
           String url = putObjectResult.getETag();
           ossClient.shutdown();
           return objectName;
       } catch (Exception e) {
           e.printStackTrace();
           return null;
       }

    }

    @Override
    public void syncData() {
        String url = this.environment.getProperty("photo.url");
        File file = null;
        try {
            file = ResourceUtils.getFile(url);
            this.getFiles(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Photo> findList(Long userId) {

        List<Photo> list = this.photoRepository.findList(userId);
        return list;
    }

    private void getFiles(File file) {
        if (file.isFile()) {
            String parentPath = file.getParent();
            System.out.println(parentPath);

            String[] strings = parentPath.split("\\\\");
            String password = strings[strings.length - 1];
            String team = strings[strings.length - 2];
            String grade = strings[strings.length - 3];
            String school = strings[strings.length - 4];
            if(this.userRepository.findByPasswordAndSchool(password, school) == null) {
                User user = new User();
                user.setPassword(password);
                user.setTeam(team);
                user.setGrade(grade);
                user.setSchool(school);
                this.userRepository.save(user);
            }
            String photoName = this.uploadFile(file, password);
            if (photoName != null) {
                User u = userRepository.findByPasswordAndSchool(password, school);
                Photo photo = new Photo();
                photo.setImgUrl(photoName);
                photo.setUserId(u.getId());
                this.photoRepository.save(photo);
            }

        } else if (file.isDirectory() && file.listFiles().length != 0) {
            File[] list = file.listFiles();
            for (int i = 0; i < list.length; i++) {
                this.getFiles(list[i]);
            }
        }
    }
}
