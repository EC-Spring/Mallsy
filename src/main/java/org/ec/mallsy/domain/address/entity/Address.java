package org.ec.mallsy.domain.address.entity;

import org.ec.mallsy.domain.user.entity.User;

import javax.persistence.*;

@Entity
@Table(name = "Address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 64)
    private String type;
    @Column(nullable = false, length = 256)
    private String address;
    @Column(nullable = false)
    private Long updatedAt;

    @ManyToOne
    @JoinColumn(name = "userId", insertable = false, updatable = false)
    private User user;
}
