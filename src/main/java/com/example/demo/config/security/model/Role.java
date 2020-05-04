package com.example.demo.config.security.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.NaturalId;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "role")

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor

@Builder
@EqualsAndHashCode(of = "id")
@ToString
public class Role implements GrantedAuthority {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NaturalId
    @Column(name = "role_name", unique = true, nullable = false, updatable = false)
    private String roleName;

    @Builder.Default
    @ManyToMany(mappedBy = "roles", cascade = {CascadeType.REFRESH},
            fetch = FetchType.LAZY, targetEntity = User.class)
    private Set<User> users = new HashSet<>();

    @JsonIgnore
    @Override
    public String getAuthority() {
        return this.roleName;
    }
}
