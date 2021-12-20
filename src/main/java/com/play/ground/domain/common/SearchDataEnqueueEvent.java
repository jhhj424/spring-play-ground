package com.play.ground.domain.common;

import com.play.ground.domain.common.SearchDataEnqueueType;
import lombok.Getter;

@Getter
public class SearchDataEnqueueEvent {
    private final Long shopId;
    private final SearchDataEnqueueType type;

    public SearchDataEnqueueEvent(Long shopId, SearchDataEnqueueType type) {
        this.shopId = shopId;
        this.type = type;
    }
}
