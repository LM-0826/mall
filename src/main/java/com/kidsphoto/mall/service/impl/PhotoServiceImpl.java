package com.kidsphoto.mall.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import com.kidsphoto.mall.dao.PhotoMapper;
import com.kidsphoto.mall.dao.PhotoRepository;
import com.kidsphoto.mall.dao.PhotoTypeRepository;
import com.kidsphoto.mall.dao.UserRepository;
import com.kidsphoto.mall.entity.Photo;
import com.kidsphoto.mall.entity.ProductS;
import com.kidsphoto.mall.entity.User;
import com.kidsphoto.mall.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import javax.annotation.Resource;
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

    @Resource
    private PhotoMapper photoMapper;

    @Autowired
    private PhotoTypeRepository photoTypeRepository;

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
        String ossUrl = this.environment.getProperty("photo.oss.url");
        File file = null;
        try {
            file = ResourceUtils.getFile(url);
            this.getFiles(file, ossUrl);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Photo> findList(Long userId) {

        List<Photo> list = this.photoRepository.findList(userId);
        return list;
    }

    @Override
    public List<ProductS> findPhotoProducts(Long photoType, Long productId, Long userId) {
        List<ProductS> list = this.photoMapper.findByType(photoType, productId, userId);
        return list;
    }

    @Override
    public List<Photo> findByPhotoTypeId(Long photoTypeId, Long userId) {
        List<Photo> list = this.photoMapper.findByPhotoTypeId(photoTypeId, userId);
        return list;
    }

    private void getFiles(File file, String url) {
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
                user.setPasswords(password);
                user.setTeam(team);
                user.setGrade(grade);
                user.setSchool(school);
                this.userRepository.save(user);
            }
            String photoPath = this.uploadFile(file, password);
            if (photoPath != null) {
                User u = userRepository.findByPasswordAndSchool(password, school);
                Photo photo = new Photo();
                String path = url + photoPath;
                photo.setImgUrl(path);
                photo.setUserId(u.getId());
                String photoName = file.getName().substring(0, file.getName().lastIndexOf('.'));
                if(photoName.length() == 1) {
                    photo.setTypeId(this.photoTypeRepository.findByName("Personal_Portrait"));
                } else {
                    photo.setTypeId(this.photoTypeRepository.findByName(photoName));
                }
                this.photoRepository.save(photo);
            }

        } else if (file.isDirectory() && file.listFiles().length != 0) {
            File[] list = file.listFiles();
            for (int i = 0; i < list.length; i++) {
                this.getFiles(list[i], url);
            }
        }
    }

    public static void main(String[] args) {
        String a = "A.jpg";
        String b = a.substring(0, a.lastIndexOf('.'));
        System.out.println(b);
    }
}
