package com.kidsphoto.mall.controller;

import com.kidsphoto.mall.entity.BusinessException;
import com.kidsphoto.mall.entity.SchoolPicture;
import com.kidsphoto.mall.pojo.ResponseResult;
import com.kidsphoto.mall.service.SchoolPictureService;
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
 * @create 2019-11-27 14:40
 */
@RestController
@RequestMapping("/schoolPicture")
@Api(value = "学校首页照片实体操作")
public class SchoolPictureController {

    @Autowired
    private SchoolPictureService schoolPictureService;

    @RequestMapping(value = "/save", method = RequestMethod.GET)
    @ApiOperation(value = "新建")
    public ResponseResult save(@RequestParam("schoolName") String schoolName, @RequestParam("pictureUrl") String pictureUrl) {

        try {
            schoolPictureService.save(schoolName, pictureUrl);
            return ResponseResult.ok();
        } catch (Exception e) {
            if (e instanceof BusinessException) {
                return ResponseResult.fail(e.getMessage());
            }
            return ResponseResult.fail();
        }

    }


    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ApiOperation(value = "删除")
    public ResponseResult delete(@RequestParam("id") Long id) {

        try {
            schoolPictureService.delete(id);
            return ResponseResult.ok();
        } catch (Exception e) {
            if (e instanceof BusinessException) {
                return ResponseResult.fail(e.getMessage());
            }
            return ResponseResult.fail();
        }
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ApiOperation(value = "查询学校图片列表")
    public ResponseResult list() {
        List<SchoolPicture> list = schoolPictureService.list();
        return ResponseResult.ok(list);
    }

    @RequestMapping(value = "/schoolNameList", method = RequestMethod.GET)
    @ApiOperation(value = "查询所有学校名")
    public ResponseResult findSchool() {
        List<String> schoolList = schoolPictureService.schoolList();
        return ResponseResult.ok(schoolList);
    }

    @RequestMapping(value = "/picture", method = RequestMethod.GET)
    @ApiOperation(value = "获取图片")
    public ResponseResult findSchoolPicture(@RequestParam("schoolName") String schoolName) {

        SchoolPicture schoolPicture = schoolPictureService.findBySchoolName(schoolName);
        return ResponseResult.ok(schoolPicture);

    }


}
