package hobbyloop.backend.api.applicationservice.user;

import org.springframework.stereotype.Service;

import hobbyloop.backend.domain.user.User;
import hobbyloop.backend.domain.user.UserService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserApplicationService {

	private final UserService userService;

	public User findByRefreshToken(String refreshToken) {
		return userService.getUserByRefreshToken(refreshToken);
	}

	public User createUser(User user) {
		return userService.createUser(user);
	}

	public void updateUser(User user) {
		userService.createUser(user);
	}

	public User getUserByUsername(String username) {
		return userService.getUserByUsername(username);
	}
}
