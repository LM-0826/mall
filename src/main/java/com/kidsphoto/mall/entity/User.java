package com.kidsphoto.mall.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author 李明
 * @create 2019-11-08 14:08
 * 学生实体
 */
@Entity
@Table(name = "t_user")
public class User extends Data implements Serializable {

    private static final long serialVersionUID = 1144342634321762085L;

    @Column(name = "password")
    private String password;

    @Column(name = "school")
    private String school;

}
