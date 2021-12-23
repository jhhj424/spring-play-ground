package com.play.ground.domain;

import com.play.ground.config.EnqueueProcessType;
import com.play.ground.domain.annotation.EnqueueTargetField;
import com.play.ground.domain.annotation.ShopTargetQueue;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ShopTargetQueue(type = EnqueueProcessType.SHOP)
@Entity
@Table(name = "shop")
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @EnqueueTargetField
    private Long id;

    private String name;

    private Shop(String name) {
        this(null, name);
    }

    public static Shop of(String name) {
        return new Shop(name);
    }

    public void update(Shop updateShop) {
        this.name = updateShop.getName();
    }
}
