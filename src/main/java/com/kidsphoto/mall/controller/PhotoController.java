package com.kidsphoto.mall.controller;

import com.kidsphoto.mall.entity.Photo;
import com.kidsphoto.mall.entity.ProductS;
import com.kidsphoto.mall.pojo.ResponseResult;
import com.kidsphoto.mall.service.PhotoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    @ApiOperation(value = "同步数据")
    public ResponseResult syncData() {
        try {
            photoService.syncData();
            return ResponseResult.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseResult.fail(e.getMessage());
        }
    }

    @RequestMapping(value = "/photoList", method = RequestMethod.GET)
    @ApiOperation(value = "查询用户所有照片")
    public ResponseResult photoList(@RequestParam("userId") Long userId) {
        List<Photo> list = this.photoService.findList(userId);
        return ResponseResult.ok(list);
    }


    @RequestMapping(value = "/photoProducts", method = RequestMethod.GET)
    @ApiOperation(value = "某产品类型下的所有照片商品")
    public ResponseResult photoProducts(@RequestParam("photoType") Long photoType, @RequestParam("productId") Long productId, @RequestParam("userId") Long userId) {
        List<ProductS> list = this.photoService.findPhotoProducts(photoType, productId, userId);
        return ResponseResult.ok(list);
    }


    @RequestMapping(value = "/findByPhotoTypeId", method = RequestMethod.GET)
    @ApiOperation(value = "根据照片类型id查询照片")
    public ResponseResult findByPhotoTypeId (@RequestParam("photoTypeId") Long photoTypeId, @RequestParam("userId") Long userId) {
        List<Photo> list = photoService.findByPhotoTypeId(photoTypeId, userId);
        return ResponseResult.ok(list);
    }


}
