package com.play.ground.application;

import com.play.ground.config.EnqueueProcessType;

public class EnqueueProcessFactory {

    public static EnqueueProcess create(EnqueueProcessType type) {
        if (type == EnqueueProcessType.SHOP) {
            return new ShopEnqueueProcess();
        }
        if (type == EnqueueProcessType.STYLER) {
            return new StylerEnqueueProcess();
        }
        if (type == EnqueueProcessType.EXHIBITION) {
            return new ExhibitionEnqueueProcess();
        }
        throw new IllegalArgumentException("Illegal type");
    }
}
