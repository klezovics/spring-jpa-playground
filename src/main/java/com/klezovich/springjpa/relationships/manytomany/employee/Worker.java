package com.klezovich.springjpa.relationships.manytomany.employee;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

@Entity
public class Worker {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="worker_project",
            joinColumns = {@JoinColumn(name = "worker_id")},
            inverseJoinColumns = {@JoinColumn(name="project_id")}
    )
    @Fetch(FetchMode.SUBSELECT)
    private Set<Project> projects = new HashSet<>();


    public void addProject(Project project) {
        if(Objects.isNull(project.getWorkers())) {
            project.setWorkers(new HashSet<>());
        }

        var employees = project.getWorkers();
        employees.add(this);

        if(Objects.isNull(projects)) {
            projects = new HashSet<>();
        }

        this.projects.add(project);
    }
}
