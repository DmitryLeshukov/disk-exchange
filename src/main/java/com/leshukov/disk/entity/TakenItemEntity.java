package com.leshukov.disk.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

/**
 * @author dleshukov@alvioneurope.ru
 */
@Data
@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Table(name = "TAKEN_ITEM")
public class TakenItemEntity extends BaseEntity {

    @ManyToOne(optional = false)
    @JoinColumn(name = "HOLDER_ID")
    private UserEntity holder;

    @OneToOne(optional = false, mappedBy = "takenItem")
    private DiskEntity disk;

    @Builder
    public TakenItemEntity(Long id, Date createdDate, Date modifiedDate, UserEntity holder, DiskEntity disk) {
        super(id, createdDate, modifiedDate);
        this.holder = holder;
        this.disk = disk;
    }
}
