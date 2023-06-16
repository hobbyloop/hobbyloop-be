package hobbyloop.backend.api.applicationservice.user;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import hobbyloop.backend.api.infra.global.oauth2.OAuth2UserDetails;
import hobbyloop.backend.domain.user.Role;
import hobbyloop.backend.domain.user.SocialType;
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

	public User getUserBySocialTypeAndSocialId(SocialType socialType, String id) {
		return userService.getUserBySocialTypeAndSocialId(socialType, id);
	}
}
