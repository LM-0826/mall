package com.kidsphoto.mall.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author 李明
 * @create 2019-11-27 14:33
 */
@Entity
@Table(name = "t_school_picture")
@lombok.Data
public class SchoolPicture extends Data implements Serializable {

    @Column(name = "picture_url")
    private String pictureUrl;

    @Column(name = "school_name")
    private String schoolName;

    @Column(name = "chinese_title")
    private String chineseTitle;

    @Column(name = "english_title")
    private String englishTitle;
}
