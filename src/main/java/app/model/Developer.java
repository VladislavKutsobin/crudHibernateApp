package app.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "developers")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode

public class Developer extends BaseEntity {
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "specialty")
    private String specialty;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "developers_skills", joinColumns = {
            @JoinColumn(name = "developer_id", insertable = false, nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "skill_id", insertable = false, nullable = false, updatable = false)})
    private Set<Skill> skills;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "developers_accounts",
        joinColumns = @JoinColumn(name = "developer_id"),
        inverseJoinColumns = @JoinColumn(name = "account_id")
    )
    private Account account;

}
