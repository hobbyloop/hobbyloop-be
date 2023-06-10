package hobbyloop.backend.domain.userProfile;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import hobbyloop.backend.domain.user.User;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

	Optional<UserProfile> findByUser(User user);
}
