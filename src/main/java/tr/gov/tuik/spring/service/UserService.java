package tr.gov.tuik.spring.service;

import tr.gov.tuik.spring.domain.User;
import tr.gov.tuik.spring.domain.UserCreateForm;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by Hasan TEKGÜL
 * on 6/2/2015
 */
public interface UserService {

    Optional<User> getUSerById(Long id);

    Optional<User> getUserByEmail(String email);

    Collection<User> getAllUsers();

    User create(UserCreateForm form);
}
