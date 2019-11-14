package com.kidsphoto.mall.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * @author 李明
 * @create 2019-11-04 18:01
 */
@MappedSuperclass
@lombok.Data
public abstract class Data {

    /**
     * 有效
     */
    public static final int ROW_STATE_0 = 0;

    /**
     * 已删除
     */
    public static final int ROW_STATE_1 = 1;

    @Column(name = "row_state", nullable = false, columnDefinition = "integer NOT NULL DEFAULT 0")
    private int rowState;

    public Data() {
        createDate = new Date();
    }

    @Column(name = "create_date", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createDate;

    @Column(name = "last_modified_date", nullable = false,  columnDefinition = "timestamp  DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date lastModifiedDate;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


}
