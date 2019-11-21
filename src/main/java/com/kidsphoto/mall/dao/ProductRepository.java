package com.kidsphoto.mall.dao;

import com.kidsphoto.mall.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 李明
 * @create 2019-11-21 8:59
 */
@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    @Query(value = "SELECT * FROM t_product WHERE id = :productId AND row_state = 0", nativeQuery = true)
    Product findProduct(Long productId);

    @Query(value = "SELECT * FROM t_product WHERE school = :school AND row_state = 0 LIMIT :offset , :size", nativeQuery = true)
    List<Product> findList(String school, int offset, int size);
}
