package dj.aurelia.aureliaclient.domain.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "AUTHORITY")
public class Authority {

    @Id
    @Column(name = "ID")
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "authority_seq")
//    @SequenceGenerator(name = "authority_seq", sequenceName = "authority_seq", allocationSize = 1)
    private Long id;

    @Column(name = "NAME", length = 50)
    @NotNull
    @Enumerated(EnumType.STRING)
    private AuthorityName name;

    @JsonIgnore
    @Column(name = "USERS")
    @ElementCollection
    @Type(type ="uuid-char")
    private List<UUID> users;


}
