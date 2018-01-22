package org.evertones.model.security;

import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
public class Users implements UserDetails {

    private String password;
    private String username;
    private boolean enabled;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private Set<Authorities> authorities;

    @Id
    @NotNull
    @Override
    public String getUsername() {
        return username;
    }

    public Users setUsername(String username) {
        this.username = username;
        return this;
    }

    @NotNull
    public String getPassword() {
        return password;
    }

    public Users setPassword(String password) {
        this.password = password;
        return this;
    }

    @NotNull
    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public Users setEnabled(boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.accountNonExpired;
    }

    public Users setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
        return this;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }

    public Users setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
        return this;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialsNonExpired;
    }

    public Users setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
        return this;
    }

    @Override
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "username")
    public Set<Authorities> getAuthorities() {
        return this.authorities;
    }

    public Users setAuthorities(Set<Authorities> authorities) {
        this.authorities = authorities;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Users users = (Users) o;

        if (!password.equals(users.password)) return false;
        return username.equals(users.username);

    }

    @Override
    public int hashCode() {
        int result = password.hashCode();
        result = 31 * result + username.hashCode();
        return result;
    }
}
