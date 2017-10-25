package com.leshukov.disk.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Table(name = "ROLE")
public class RoleEntity extends BaseEntity {

    @Column(name = "NAME")
    private String name;

    @Builder
    public RoleEntity(Long id, Date createdDate, Date modifiedDate, String name) {
        super(id, createdDate, modifiedDate);
        this.name = name;
    }
}
