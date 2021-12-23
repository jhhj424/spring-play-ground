package com.play.ground.application;

import org.springframework.stereotype.Component;

@Component
public class ExhibitionEnqueueProcess implements EnqueueProcess {
    @Override
    public long getShopId(long searchId) {
        return 0;
    }
}
