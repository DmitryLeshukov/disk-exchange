package com.leshukov.disk.service.impl;

import com.leshukov.disk.dto.DiskDto;
import com.leshukov.disk.dto.IdDto;
import com.leshukov.disk.dto.UserDto;
import com.leshukov.disk.entity.DiskEntity;
import com.leshukov.disk.entity.TakenItemEntity;
import com.leshukov.disk.entity.UserEntity;
import com.leshukov.disk.exception.DiskPickException;
import com.leshukov.disk.exception.DiskReturnException;
import com.leshukov.disk.repository.DiskRepository;
import com.leshukov.disk.repository.UserRepository;
import com.leshukov.disk.service.DiskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author dleshukov@alvioneurope.ru
 */
@Service
@Transactional
public class DiskServiceImpl implements DiskService {

    @Autowired
    private DiskRepository diskRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<DiskDto> findAllFreeDisks() {

        return diskRepository.findAllFreeDisks().stream().map(
                diskEntity -> DiskDto.builder()
                        .id(diskEntity.getId())
                        .title(diskEntity.getTitle())
                        .year(diskEntity.getYear())
                        .owner(UserDto.builder()
                                .id(diskEntity.getOwner().getId())
                                .firstName(diskEntity.getOwner().getFirstName())
                                .lastName(diskEntity.getOwner().getLastName())
                                .middleName(diskEntity.getOwner().getMiddleName())
                                .build()
                        )
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public List<DiskDto> findAllHoldByMeDisks(String login) {
        return userRepository.findByLogin(login).getHoldDisks().stream().map(
                entity -> {
                    DiskEntity diskEntity = entity.getDisk();
                    return DiskDto.builder()
                            .id(diskEntity.getId())
                            .title(diskEntity.getTitle())
                            .year(diskEntity.getYear())
                            .owner(UserDto.builder()
                                    .id(diskEntity.getOwner().getId())
                                    .firstName(diskEntity.getOwner().getFirstName())
                                    .lastName(diskEntity.getOwner().getLastName())
                                    .middleName(diskEntity.getOwner().getMiddleName())
                                    .build())
                            .build();
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<DiskDto> findAllHoldByOthersDisks(String login) {
        return userRepository.findByLogin(login).getOwnedDisks().stream()
                .filter(diskEntity -> diskEntity.getTakenItem() != null)
                .map(diskEntity -> {
                    UserEntity holder = diskEntity.getTakenItem().getHolder();
                    return DiskDto.builder()
                            .id(diskEntity.getId())
                            .title(diskEntity.getTitle())
                            .year(diskEntity.getYear())
                            .holder(UserDto.builder()
                                    .id(holder.getId())
                                    .firstName(holder.getFirstName())
                                    .lastName(holder.getLastName())
                                    .middleName(holder.getMiddleName())
                                    .build())
                            .build();
                })
                .collect(Collectors.toList());
    }

    @Override
    public void returnDisk(Long diskId, String login) {
        UserEntity userEntity = userRepository.findByLogin(login);
        DiskEntity diskEntity = diskRepository.findOne(diskId);

        if (diskEntity.getTakenItem() == null) {
            throw new DiskReturnException("Disk already returned");
        }

        if (!diskEntity.getTakenItem().getHolder().equals(userEntity)) {
            throw new DiskReturnException("You can't return disk hold by other user");
        }

        diskEntity.setTakenItem(null);
    }

    @Override
    public void pickDisk(Long diskId, String login) {
        UserEntity userEntity = userRepository.findByLogin(login);
        DiskEntity diskEntity = diskRepository.findOne(diskId);

        if (diskEntity.getOwner().equals(userEntity)) {
            throw new DiskPickException("You can't pick own disk");
        }

        if (diskEntity.getTakenItem() != null) {
            throw new DiskPickException("Disk already picked");
        }

        TakenItemEntity takenItemEntity = TakenItemEntity.builder()
                .disk(diskEntity)
                .holder(userEntity)
                .build();

        diskEntity.setTakenItem(takenItemEntity);
    }

    @Override
    public IdDto create(DiskDto diskDto, String login) {
        UserEntity userEntity = userRepository.findByLogin(login);

        DiskEntity save = diskRepository.save(DiskEntity.builder()
                .title(diskDto.getTitle())
                .description(diskDto.getDescription())
                .year(diskDto.getYear())
                .owner(userEntity)
                .build());

        return IdDto.builder().id(save.getId()).build();
    }

}
