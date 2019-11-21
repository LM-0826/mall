package com.kidsphoto.mall.dao;

import com.kidsphoto.mall.entity.Photo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 李明
 * @create 2019-11-14 18:14
 */
@Repository
public interface PhotoRepository extends CrudRepository<Photo, Long> {

    @Query(value = "SELECT * FROM t_photo WHERE row_state = 0 AND user_id = :userId", nativeQuery = true)
    List<Photo> findList(Long userId);
}
