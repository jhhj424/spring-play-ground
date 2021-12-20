package com.play.ground.domain;

import com.play.ground.domain.common.SearchDataEnqueue;
import com.play.ground.domain.common.SearchDataEnqueueType;
import lombok.Data;

import javax.persistence.*;

@Data
@SearchDataEnqueue(type = SearchDataEnqueueType.SHOP)
@Entity
@Table(name = "shop")
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    public void update(Shop shop) {
        this.name = shop.name;
    }
}
