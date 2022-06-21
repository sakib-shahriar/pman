package com.ssdev.pman.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "card")
public class Card extends BaseEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 100, nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "card_list_id", nullable = false)
    private CardList cardList;
}
