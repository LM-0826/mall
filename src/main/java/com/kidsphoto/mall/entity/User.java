package com.kidsphoto.mall.entity;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author 李明
 * @create 2019-11-11 11:46
 */
@Entity
@lombok.Data
@Table(name = "t_user")
public class User extends Data implements Serializable {

    @Column(name = "password")
    private String Password;

    @Column(name = "school")
    private String School;
}
