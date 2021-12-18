package com.play.ground.domain;

import com.play.ground.domain.common.EnqueueEntity;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "shop")
public class Shop implements EnqueueEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    public void update(Shop shop) {
        this.name = shop.name;
    }

    @Override
    public EnqueueEvent getEvent() {
        return new ShopEnqueueEvent(id);
    }
}
