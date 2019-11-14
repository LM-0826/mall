package com.kidsphoto.mall.dao;

import com.kidsphoto.mall.entity.Photo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author 李明
 * @create 2019-11-14 18:14
 */
@Repository
public interface PhotoRepository extends CrudRepository<Photo, Long> {
}
