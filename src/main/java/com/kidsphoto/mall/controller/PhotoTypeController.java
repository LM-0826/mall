package com.kidsphoto.mall.controller;

import com.kidsphoto.mall.entity.BusinessException;
import com.kidsphoto.mall.entity.PhotoType;
import com.kidsphoto.mall.pojo.ResponseResult;
import com.kidsphoto.mall.service.PhotoTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 李明
 * @create 2019-11-20 14:40
 */
@RestController
@RequestMapping("/photoType")
@Api(value = "照片类型实体的操作", tags = "照片类型实体的操作")
public class PhotoTypeController {

    @Autowired
    private PhotoTypeService photoTypeService;

    /**
     * 创建照片类型
     * @param photoTypeName
     * @return
     */

    @ApiOperation(value = "新建照片类型")
    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public ResponseResult save(@RequestParam("photoTypeName") String photoTypeName, @RequestParam("schoolName") String schoolName) {
        try {
            this.photoTypeService.save(photoTypeName, schoolName);
            return ResponseResult.ok();
        } catch (Exception e) {
            return ResponseResult.fail(e.getMessage());
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ApiOperation(value = "删除照片类型实体")
    public  ResponseResult delete(@RequestParam("id") Long id) {

        try {
            this.photoTypeService.delete(id);
            return ResponseResult.ok();
        } catch (Exception e) {
            if (e instanceof BusinessException) {
                return ResponseResult.fail(e.getMessage());
            }
            return ResponseResult.fail();
        }
    }

    @RequestMapping(value = "/queryList", method = RequestMethod.GET)
    @ApiOperation(value = "查询某个学校下所有照片类型")
    public ResponseResult queryList(@RequestParam("schoolName") String schoolName) {
        try {
            List<PhotoType> list = this.photoTypeService.findBySchoolName(schoolName);
            return ResponseResult.ok(list);
        } catch (Exception e) {
            if (e instanceof BusinessException) {
                return ResponseResult.fail(e.getMessage());
            }
            return ResponseResult.fail();
        }
    }

//    @RequestMapping(value = "/querySchooles", method = RequestMethod.GET)
//    @ApiOperation(value = "查询所有学校")
//    public ResponseResult querySchooles() {
//
//        try {
//            List<String> list = this.photoTypeService.findSchoolName();
//            return ResponseResult.ok(list);
//        } catch (Exception e) {
//            if (e instanceof BusinessException) {
//                return ResponseResult.fail(e.getMessage());
//            }
//            return ResponseResult.fail();
//        }
//    }

}
