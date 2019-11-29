package com.kidsphoto.mall.dao;

import com.kidsphoto.mall.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 李明
 * @create 2019-11-21 8:59
 */
@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    @Query(value = "SELECT * FROM t_product WHERE id = :productId AND row_state = 0", nativeQuery = true)
    Product findProduct(@Param("productId") Long productId);

    @Query(value = "SELECT * FROM t_product WHERE school = :school AND row_state = 0 LIMIT :offset , :size ", nativeQuery = true)
    List<Product> findList(@Param("school") String school, @Param("offset") int offset, @Param("size") int size);

    @Query(value = "SELECT * FROM t_product WHERE school = :school ", nativeQuery = true)
    List<Product> findBySchool(@Param("school") String school);

    @Query(value = "SELECT COUNT(*) FROM t_product WHERE school = :school AND row_state = 0", nativeQuery = true)
    int findCount(@Param("school") String school);

    @Query(value = "SELECT * FROM t_product WHERE school = :schoolName AND row_state = 0 AND flag = 1", nativeQuery = true)
    List<Product> findHaveStandard(@Param("schoolName") String schoolName);

}
