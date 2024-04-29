package dev.toke.springthymehtmxstarter.data.model;


import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "Harness")
public class Harness extends BaseComponent {
    private String revision;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parentId", referencedColumnName = "id")
    private Harness parentHarness = null;
    @OneToMany(mappedBy = "parentHarness")
    private Set<Harness> children = new HashSet<>();
}
