package com.play.ground.domain;

import com.play.ground.domain.common.EnqueueType;

public class Process {
    private final EnqueueEvent enqueueEvent;

    public Process(EnqueueEvent enqueueEvent) {
        this.enqueueEvent = enqueueEvent;
    }

    public void enqueue() {
        if (enqueueEvent.getType() == EnqueueType.SHOP) {
            // TODO: 2021/12/17
        }
        if (enqueueEvent.getType() == EnqueueType.STYLER) {
            // TODO: 2021/12/17
        }
    }
}
