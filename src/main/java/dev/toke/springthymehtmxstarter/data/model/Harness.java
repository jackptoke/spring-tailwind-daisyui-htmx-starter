package dev.toke.springthymehtmxstarter.data.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Harness")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Harness extends BaseComponent {
    private String revision;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parentId", referencedColumnName = "id")
    private Harness parentHarness = null;
    @OneToMany(mappedBy = "parentHarness")
    private Set<Harness> children = new HashSet<>();
}
