package com.leshukov.disk.repository;

import com.leshukov.disk.entity.DiskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author dleshukov@alvioneurope.ru
 */
public interface DiskRepository extends JpaRepository<DiskEntity, Long> {

    @Query("select disk from DiskEntity disk where disk.takenItem is null")
    List<DiskEntity> findAllFreeDisks();
}
