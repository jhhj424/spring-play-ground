package com.play.ground.application;

import com.play.ground.config.EnqueueProcessType;

public class EnqueueProcessFactory {

    public static EnqueueProcess create(EnqueueProcessType type) {
        if (type == EnqueueProcessType.SHOP) {
            return new ShopEnqueueProcess();
        }
        if (type == EnqueueProcessType.SHOP_BREAK_TIME) {
            return new ShopBreakTimeEnqueueProcess();
        }
        if (type == EnqueueProcessType.EXHIBITION) {
            return new ExhibitionEnqueueProcess();
        }
        throw new IllegalArgumentException("Illegal type");
    }
}
