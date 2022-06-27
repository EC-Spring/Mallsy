package org.ec.mallsy.domain.delivery.delivery;

import org.ec.mallsy.domain.Image.entity.Image;
import org.ec.mallsy.domain.user.entity.User;

import javax.persistence.*;

@Entity
@Table(name = "Delivery")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Long orderNumber;

    @Column(nullable = false)
    private Long sellerId;

    @Column(nullable = false, length = 64)
    private String status;
    @Column(nullable = false)
    private Long orderedAt;

    @Column(nullable = false)
    private Long partNumber;
    @Column(nullable = false, length = 64)
    private String title;
    @Column(nullable = false)
    private Long price;
    @Column(nullable = false)
    private Long amount;
    @Column(nullable = false, length = 64)
    private String optional;

    @Column(nullable = false, length = 256)
    private String address;

    @OneToOne(mappedBy = "delivery", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Image previewImage;

    @ManyToOne
    @JoinColumn(name = "userId", insertable = false, updatable = false)
    private User user;
}
