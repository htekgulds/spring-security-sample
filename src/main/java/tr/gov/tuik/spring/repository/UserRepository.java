package tr.gov.tuik.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.gov.tuik.spring.domain.User;

import java.util.Optional;

/**
 * Created by Hasan TEKGÜL
 * on 6/2/2015
 */
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findOneByEmail(String email);
}
