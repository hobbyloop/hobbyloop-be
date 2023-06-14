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

	public User getsUserByEmail(String email) {
		return userRepository.findByEmail(email).orElseThrow(EntityNotFoundException::new);
	}

	public User getUserByRefreshToken(String refreshToken) {
		return userRepository.findByRefreshToken(refreshToken).orElseThrow(EntityNotFoundException::new);
	}

	public User getUserBySocialTypeAndSocialId(SocialType socialType, String id) {
		return userRepository.findBySocialTypeAndSocialId(socialType, id).orElseThrow(EntityNotFoundException::new);
	}

	public User getOrCreateUser(SocialType socialType, String id, User newUser) {
		return userRepository.findBySocialTypeAndSocialId(socialType, id)
			.orElseGet(() -> userRepository.save(newUser));
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
}
