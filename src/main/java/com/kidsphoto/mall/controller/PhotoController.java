package com.kidsphoto.mall.controller;

import com.kidsphoto.mall.pojo.ResponseResult;
import com.kidsphoto.mall.service.PhotoService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 李明
 * @create 2019-11-13 13:15
 */
@RestController
@Slf4j
@RequestMapping(value = "/photo")
@Api(value = "图片上传controller", tags = "图片上传接口")
public class PhotoController {

    @Autowired
    private PhotoService photoService;

//    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
//    public ResponseResult upload(HttpServletRequest request, @RequestParam("file") MultipartFile file) {
//        try {
//            photoService.uploadFile(file, file.getOriginalFilename());
//            return ResponseResult.ok();
//        } catch (Exception e) {
//            return ResponseResult.fail();
//        }
//    }

    /**
     * 同步数据
     * @return
     */
    @RequestMapping(value = "/syncDate", method = RequestMethod.GET)
    public ResponseResult syncData() {
        try {
            photoService.syncData();
            return ResponseResult.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseResult.fail(e.getMessage());
        }
    }

}
