package com.ssdev.pman.model.event;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class EventTask {
    @Id
    @GeneratedValue
    private Long id;
}
