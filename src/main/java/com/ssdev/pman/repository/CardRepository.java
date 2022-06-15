package com.ssdev.pman.repository;

import com.ssdev.pman.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {

}
