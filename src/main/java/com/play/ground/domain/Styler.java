
package com.play.ground.domain;

import com.play.ground.domain.common.SearchDataEnqueue;
import com.play.ground.domain.common.SearchDataEnqueueType;
import lombok.Data;

import javax.persistence.*;


@Data
@SearchDataEnqueue(type = SearchDataEnqueueType.STYLER)
@Entity
@Table(name = "styler")
public class Styler {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    public Long getId() {
        return id;
    }
}
