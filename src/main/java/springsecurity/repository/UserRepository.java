package springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springsecurity.domain.UserInfo;
import java.util.Optional;

public interface UserRepository extends JpaRepository< UserInfo , Long > {
    Optional<UserInfo> findByEmail( String email );
}
