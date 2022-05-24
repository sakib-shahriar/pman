package com.ssdev.pman.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class EventTask extends BaseModel {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;
}
