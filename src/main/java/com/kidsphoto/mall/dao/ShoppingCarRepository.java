package com.kidsphoto.mall.dao;

import com.kidsphoto.mall.entity.ShoppingCar;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 李明
 * @create 2019-11-25 14:53
 */
@Repository
public interface ShoppingCarRepository extends CrudRepository<ShoppingCar, Long> {

    @Query(value = "SELECT * FROM t_shopping_car WHERE row_state = 0 AND user_id = :userId", nativeQuery = true)
    List<ShoppingCar> findByUserId(@Param("userId") Long userId);

    @Query(value = "UPDATE SET row_state = 1 FROM t_shopping_car WHERE id = :id", nativeQuery = true)
    int deleteShopping(@Param("id") Long id);
}
