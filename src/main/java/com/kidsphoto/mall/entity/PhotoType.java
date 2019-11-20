package com.kidsphoto.mall.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author 李明
 * @create 2019-11-20 11:51
 */
@Entity
@lombok.Data
@Table(name = "t_photo_type")
public class PhotoType extends Data implements Serializable {

    @Column(name = "type_name")
    private String TypeName;

    @Column(name = "school_name")
    private String SchoolName;
}
