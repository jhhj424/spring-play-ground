package com.play.ground.domain;

import com.play.ground.domain.common.SearchDataEnqueueEvent;
import com.play.ground.domain.common.SearchDataEnqueueType;

public class Process {
    private final SearchDataEnqueueEvent enqueueEvent;

    public Process(SearchDataEnqueueEvent enqueueEvent) {
        this.enqueueEvent = enqueueEvent;
    }

    public void enqueue() {
        if (enqueueEvent.getType() == SearchDataEnqueueType.SHOP) {
            // TODO: 2021/12/17
        }
        if (enqueueEvent.getType() == SearchDataEnqueueType.STYLER) {
            // TODO: 2021/12/17
        }
    }
}
