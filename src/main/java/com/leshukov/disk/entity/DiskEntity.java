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
@Table(name = "DISK")
public class DiskEntity extends BaseEntity {

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "YEAR")
    private int year;

    @ManyToOne(optional = false)
    @JoinColumn(name = "OWNER_ID", nullable = false, updatable = false)
    private UserEntity owner;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "TAKEN_ITEM_ID")
    private TakenItemEntity takenItem;

    @Builder
    public DiskEntity(Long id, Date createdDate, Date modifiedDate, String title, String description, int year, UserEntity owner, TakenItemEntity takenItem) {
        super(id, createdDate, modifiedDate);
        this.title = title;
        this.description = description;
        this.year = year;
        this.owner = owner;
        this.takenItem = takenItem;
    }
}
