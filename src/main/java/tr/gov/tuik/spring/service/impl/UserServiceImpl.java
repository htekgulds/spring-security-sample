package tr.gov.tuik.spring.service.impl;

import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import tr.gov.tuik.spring.domain.User;
import tr.gov.tuik.spring.domain.UserCreateForm;
import tr.gov.tuik.spring.repository.UserRepository;
import tr.gov.tuik.spring.service.UserService;

import javax.inject.Inject;
import java.util.Collection;
import java.util.Optional;

/**
 * Created by Hasan TEKGÜL
 * on 6/2/2015
 */

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Inject
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> getUSerById(Long id) {
        return Optional.ofNullable(userRepository.findOne(id));
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findOneByEmail(email);
    }

    @Override
    public Collection<User> getAllUsers() {
        return userRepository.findAll(new Sort("email"));
    }

    @Override
    public User create(UserCreateForm form) {
        User user = new User();
        user.setEmail(form.getEmail());
        user.setPasswordHash(new BCryptPasswordEncoder().encode(form.getPassword()));
        user.setRole(form.getRole());
        return userRepository.save(user);
    }
}
