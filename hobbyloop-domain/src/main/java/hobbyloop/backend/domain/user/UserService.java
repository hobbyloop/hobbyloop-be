package hobbyloop.backend.domain.user;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;

	public Optional<User> getUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	public User getsUserByEmail(String email) {
		return userRepository.findByEmail(email).orElseThrow(EntityNotFoundException::new);
	}

	public Optional<User> getUserByRefreshToken(String refreshToken) {
		return userRepository.findByRefreshToken(refreshToken);
	}

	public Optional<User> getUserBySocialTypeAndSocialId(SocialType socialType, String id) {
		return userRepository.findBySocialTypeAndSocialId(socialType, id);
	}

	public User getUserById(Long userId) {
		return userRepository.findById(userId).orElseThrow(EntityNotFoundException::new);
	}

	@Transactional
	public User createUser(User user) {
		return userRepository.save(user);
	}

	@Transactional
	public void updateUserRole(User user) {
		user.updateUserRole(Role.USER);
		userRepository.save(user);

	}

	public Optional<User> getUserByAccessToken(String accessToken) {
		return userRepository.findByAccessToken(accessToken);
	}
}
