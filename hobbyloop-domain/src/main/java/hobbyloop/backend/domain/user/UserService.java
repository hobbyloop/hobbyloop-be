package hobbyloop.backend.domain.user;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;

	public User getUserByRefreshToken(String refreshToken) {
		return userRepository.findByRefreshToken(refreshToken).orElseThrow(EntityNotFoundException::new);
	}

	public User getUserByUsername(String username) {
		return userRepository.findByUsername(username).orElseThrow(EntityNotFoundException::new);
	}

	public User getOrCreateUser(String username, String email) {
		return userRepository.findByUsername(username)
			.orElseGet(
				() -> userRepository.save(User.builder()
					.username(username)
					.email(email)
					.roles(Role.GUEST.name())
					.build()
				));
	}

	@Transactional
	public User createUser(User user) {
		return userRepository.save(user);
	}

	@Transactional
	public void appendUserRole(User user, Role role) {
		user.appendUserRole(role);
		userRepository.save(user);
	}
}
