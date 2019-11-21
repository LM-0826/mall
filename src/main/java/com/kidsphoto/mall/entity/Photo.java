package com.kidsphoto.mall.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.List;

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

    //1 个人肖像 2 Calendar 3 Class_Montage 4 Class_Photo 5 ID_Photo 6 Individual_Montage 7 Wallet_Portrait
    @Column(name = "type_id")
    private int typeId;

    //照片对于的商品
    @Transient
    private List<Product> products;
}
