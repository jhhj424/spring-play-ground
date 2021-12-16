
package com.play.ground.domain;

import javax.persistence.*;

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
