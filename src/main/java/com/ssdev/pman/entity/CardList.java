package com.ssdev.pman.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "card_list")
public class CardList extends BaseEntity {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "board_id", nullable = false)
    private Board board;

    @OneToMany(mappedBy = "cardList",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Card> cards;
}
