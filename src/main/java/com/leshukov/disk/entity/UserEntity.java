package com.leshukov.disk.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @author dleshukov@alvioneurope.ru
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Table(name = "USER")
public class UserEntity extends BaseEntity {

    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;

    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    @Column(name = "MIDDLE_NAME")
    private String middleName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner", orphanRemoval = true, fetch = FetchType.LAZY)
    private List<DiskEntity> ownedDisks;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "holder", orphanRemoval = true, fetch = FetchType.LAZY)
    private List<TakenItemEntity> holdDisks;

    @Column(name = "LOGIN")
    private String login;

    @Column(name = "PASSWORD")
    private String password;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ROLE_ID")
    private RoleEntity role;

    @Builder
    public UserEntity(Long id, Date createdDate, Date modifiedDate, String lastName, String firstName, String middleName, List<DiskEntity> ownedDisks, List<TakenItemEntity> holdDisks, String login, String password, RoleEntity role) {
        super(id, createdDate, modifiedDate);
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.ownedDisks = ownedDisks;
        this.holdDisks = holdDisks;
        this.login = login;
        this.password = password;
        this.role = role;
    }
}
