package hobbyloop.backend.api.applicationservice.user;

import java.util.Optional;

import org.springframework.stereotype.Service;

import hobbyloop.backend.domain.user.SocialType;
import hobbyloop.backend.domain.user.User;
import hobbyloop.backend.domain.user.UserService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserApplicationService {

	private final UserService userService;

	public Optional<User> findByEmail(String email) {
		return userService.getUserByEmail(email);
	}

	public Optional<User> findByRefreshToken(String refreshToken) {
		return userService.getUserByRefreshToken(refreshToken);
	}

	public User createUser(User user) {
		return userService.createUser(user);
	}

	public void updateUser(User user) {
		userService.createUser(user);
	}

	public Optional<User> getUserBySocialTypeAndSocialId(SocialType socialType, String id) {
		return userService.getUserBySocialTypeAndSocialId(socialType, id);
	}

	public Optional<User> findByAccessToken(String accessToken) {
		return userService.getUserByAccessToken(accessToken);
	}
}
