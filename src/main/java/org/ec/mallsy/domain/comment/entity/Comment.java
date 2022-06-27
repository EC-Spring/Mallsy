package org.ec.mallsy.domain.comment.entity;

import org.ec.mallsy.domain.Image.entity.Image;
import org.ec.mallsy.domain.Item.entity.Item;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Long userId;
    @Column(nullable = false, length = 256)
    private String content;

    @OneToMany(mappedBy = "comment")
    private List<Image> images;

    @ManyToOne
    @JoinColumn(name = "itemId", insertable = false, updatable = false)
    private Item item;
}
