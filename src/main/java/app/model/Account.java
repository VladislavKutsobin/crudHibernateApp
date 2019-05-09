package app.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "accounts")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode

public class Account extends BaseEntity {
    @Column(name = "name")
    private String accountName;

    @OneToOne(mappedBy = "account")
    private Developer developer;

    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus;
}


