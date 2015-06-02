package tr.gov.tuik.spring.domain;

import org.springframework.security.core.authority.AuthorityUtils;
import tr.gov.tuik.spring.domain.enums.Role;

/**
 * Created by Hasan TEKGÜL
 * on 6/2/2015
 */
public class CurrentUser extends org.springframework.security.core.userdetails.User {

    private User user;

    public CurrentUser(User user) {
        super(user.getEmail(), user.getPasswordHash(), AuthorityUtils.createAuthorityList(user.getRole().toString()));
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public Long getId() {
        return user.getId();
    }

    public Role getRole() {
        return user.getRole();
    }
}
