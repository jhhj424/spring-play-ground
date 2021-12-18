package com.play.ground.domain;

import com.play.ground.domain.common.EnqueueType;
import lombok.Getter;

@Getter
public class ShopEnqueueEvent implements EnqueueEvent{
    private final Long shopId;
    private final EnqueueType enqueueType;

    public ShopEnqueueEvent(Long shopId) {
        this.shopId = shopId;
        this.enqueueType = EnqueueType.SHOP;
    }

    @Override
    public EnqueueType getType() {
        return enqueueType;
    }
}
