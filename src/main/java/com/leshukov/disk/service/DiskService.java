package com.leshukov.disk.service;

import com.leshukov.disk.dto.DiskDto;
import com.leshukov.disk.dto.IdDto;

import java.util.List;

public interface DiskService {
    List<DiskDto> findAllFreeDisks();

    void pickDisk(Long bookId, String principal);

    IdDto create(DiskDto bookDto, String principal);

    List<DiskDto> findAllHoldByMeDisks(String name);

    List<DiskDto> findAllHoldByOthersDisks(String name);

    void returnDisk(Long diskId, String name);
}
