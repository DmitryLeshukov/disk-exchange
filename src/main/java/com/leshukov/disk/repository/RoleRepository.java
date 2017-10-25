package com.leshukov.disk.repository;

import com.leshukov.disk.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author dleshukov@alvioneurope.ru
 */
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

    @Query("select role from RoleEntity role where role.name = :name")
    RoleEntity findByName(@Param("name") String name);
}
