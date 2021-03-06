package com.ssdev.pman.entity;

import com.ssdev.pman.constant.EventStatus;
import com.ssdev.pman.constant.EventType;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Event extends BaseEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, length = 30)
    private String name;

    @Column(nullable = false)
    private EventType eventType;

    @Column(nullable = false)
    private EventStatus eventStatus;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<EventTask> eventTaskList;
}
