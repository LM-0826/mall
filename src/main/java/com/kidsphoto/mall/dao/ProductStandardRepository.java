package com.kidsphoto.mall.dao;

import com.kidsphoto.mall.entity.ProductStandard;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 李明
 * @create 2019-11-22 16:52
 */
@Repository
public interface ProductStandardRepository extends CrudRepository<ProductStandard, Long> {

    @Query(value = "SELECT * FROM t_product_standard WHERE school = :school AND product_type = 1", nativeQuery = true)
    List<ProductStandard> findAList(@Param("school") String school);

    @Query(value = "SELECT * FROM t_product_standard WHERE school = :school AND product_type = 2", nativeQuery = true)
    List<ProductStandard> findBList(@Param("school") String school);

    @Query(value = "SELECT * FROM t_product_standard", nativeQuery = true)
    List<ProductStandard> findAllList();

    @Query(value = "SELECT * FROM t_product_standard WHERE school = :schoolName", nativeQuery = true)
    List<ProductStandard> findList(@Param("schoolName") String schoolName);
}
