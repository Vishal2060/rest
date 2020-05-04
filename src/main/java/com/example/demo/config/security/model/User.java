package com.example.demo.config.security.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.annotations.NaturalId;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor

@Builder
@EqualsAndHashCode(of = "id")
@ToString
public class User implements UserDetails {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NaturalId
    @Column(name = "username", unique = true, nullable = false, updatable = false)
    private String username;


    @Column(name = "password", nullable = false)
    @Setter(onMethod = @__({@JsonProperty}))
    @Getter
            (onMethod = @__({@JsonIgnore}))
    private String password;

    @Column(name = "is_enabled", nullable = false)
    private Boolean isEnabled;

    @Builder.Default
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            fetch = FetchType.EAGER,
            targetEntity = Role.class)
    @JoinTable(name = "user_roles",
            joinColumns = {@JoinColumn(name = "user_id_fk", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id_fk", referencedColumnName = "id")},
            uniqueConstraints = @UniqueConstraint(columnNames = {"user_id_fk", "role_id_fk"}))
    private Set<Role> roles = new HashSet<>();


    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return this.isEnabled;
    }
}
