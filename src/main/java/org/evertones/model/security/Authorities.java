package org.evertones.model.security;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(indexes = { @Index(name = "ix_auth_username", columnList = "username, authority") })
public class Authorities implements GrantedAuthority {

    public Authorities() {
        super();
    }

    public Authorities(String username, String authority) {
        this();
        this.setUsername(username);
        this.setAuthority(authority);
    }

    private Integer id;
    private String username;
    private String authority;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

}
