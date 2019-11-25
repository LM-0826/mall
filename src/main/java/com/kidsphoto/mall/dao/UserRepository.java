package com.kidsphoto.mall.dao;

import com.kidsphoto.mall.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author 李明
 * @create 2019-11-11 13:32
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Query(value = "SELECT * FROM t_user WHERE passwords = :password AND school = :school", nativeQuery = true)
    User findByPasswordAndSchool(@Param("password") String password, @Param("school") String school);

}
