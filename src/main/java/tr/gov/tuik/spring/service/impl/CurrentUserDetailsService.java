package tr.gov.tuik.spring.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import tr.gov.tuik.spring.domain.CurrentUser;
import tr.gov.tuik.spring.domain.User;
import tr.gov.tuik.spring.service.UserService;

import javax.inject.Inject;

/**
 * Created by Hasan TEKGÜL
 * on 6/2/2015
 */
public class CurrentUserDetailsService implements UserDetailsService {
    private final UserService userService;

    @Inject
    public CurrentUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public CurrentUser loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userService.getUserByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User with email=%s was not found", email)));
        return new CurrentUser(user);
    }
}
