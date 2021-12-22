package com.play.ground.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class EnqueueEvent {

    private final long searchId;
    private final EnqueueProcessType type;
}
