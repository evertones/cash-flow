package org.evertones.dataset;

import org.evertones.model.security.Authorities;
import org.evertones.model.security.Users;
import org.evertones.persistence.security.AuthoritiesRepository;
import org.evertones.persistence.security.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BootstrapSecurity {

    private UsersService usersService;
    private AuthoritiesRepository authorityRepository;

    @Autowired
    public void setUsersService(UsersService usersService) {
        this.usersService = usersService;
    }

    @Autowired
    public void setAuthorityRepository(AuthoritiesRepository authorityRepository) {
        this.authorityRepository = authorityRepository;
    }

    public void create() {
        Users admin = new Users()
                .setUsername("admin")
                .setPassword("password")
                .setEnabled(true)
                .setAccountNonExpired(true)
                .setAccountNonLocked(true)
                .setCredentialsNonExpired(true);
        Users user  = new Users()
                .setUsername("user")
                .setPassword("password")
                .setEnabled(true)
                .setAccountNonExpired(true)
                .setAccountNonLocked(true)
                .setCredentialsNonExpired(true);

        usersService.save(admin);
        usersService.save(user);

        Authorities userUser   = new Authorities("user", "ROLE_USER");
        Authorities adminAdmin = new Authorities("admin", "ROLE_ADMIN");
        Authorities adminUser  = new Authorities("admin", "ROLE_USER");

        authorityRepository.save(userUser);
        authorityRepository.save(adminAdmin);
        authorityRepository.save(adminUser);
    }

}
