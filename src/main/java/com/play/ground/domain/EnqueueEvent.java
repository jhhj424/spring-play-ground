package com.play.ground.domain;

import com.play.ground.domain.common.EnqueueType;

public interface EnqueueEvent {

    EnqueueType getType();
}
