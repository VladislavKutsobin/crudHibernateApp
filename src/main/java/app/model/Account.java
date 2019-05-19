package app.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "accounts")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Setter

public class Account extends BaseEntity {
    @Column(name = "name")
    private String accountName;

    @OneToOne(mappedBy = "account")
    private Developer developer;

    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus;
}


