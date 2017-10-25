package com.leshukov.disk.repository;

import com.leshukov.disk.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author dleshukov@alvioneurope.ru
 */
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    @Query("select user from UserEntity user where user.login = :login")
    UserEntity findByLogin(@Param("login") String login);
}
