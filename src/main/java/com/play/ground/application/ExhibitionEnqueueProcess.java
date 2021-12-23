package com.play.ground.application;

import org.springframework.stereotype.Component;

@Component
public class ExhibitionEnqueueProcess implements EnqueueProcess {
    @Override
    public long getShopId(long exhibitionId) {
        return 0; // exhibitionId 으로 조회
    }
}
