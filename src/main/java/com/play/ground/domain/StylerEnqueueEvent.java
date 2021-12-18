package com.play.ground.domain;

import com.play.ground.domain.common.EnqueueType;
import lombok.Getter;

@Getter
public class StylerEnqueueEvent {
    private final Long stylerId;
    private final EnqueueType enqueueType;

    public StylerEnqueueEvent(Long stylerId) {
        this.stylerId = stylerId;
        this.enqueueType = EnqueueType.STYLER;
    }
}
