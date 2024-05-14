package dev.toke.springthymehtmxstarter.data.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Harnesses")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@PrimaryKeyJoinColumn(name = "harnessId")
public class Harness extends BaseComponent {
    private String revision;

    @ManyToOne
    @JoinColumn(name = "parentId", referencedColumnName = "harnessId")
    private Harness parentHarness;

    // Anything that goes on to the harness
    @OneToMany(mappedBy = "harness")
    private List<HarnessComponent> components = new ArrayList<>();
    @OneToMany(mappedBy = "harness")
    private Set<Circuit> cables = new HashSet<>();
}
