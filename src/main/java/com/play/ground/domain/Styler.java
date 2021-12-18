
package com.play.ground.domain;

import com.play.ground.domain.common.EnqueueEntity;
import com.play.ground.domain.common.EnqueueType;

import javax.persistence.*;

@Entity
@Table(name = "styler")
public class Styler implements EnqueueEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    public Long getId() {
        return id;
    }

    @Override
    public EnqueueType getEvent() {
        return EnqueueType.STYLER;
    }
}
