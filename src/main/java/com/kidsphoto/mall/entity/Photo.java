package com.kidsphoto.mall.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author 李明
 * @create 2019-11-08 14:34
 */
@Entity
@Table(name = "t_photo")
@lombok.Data
public class Photo extends Data implements Serializable {

    private static final long serialVersionUID = -4268601820486954240L;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "img_url")
    private String imgUrl;
}
