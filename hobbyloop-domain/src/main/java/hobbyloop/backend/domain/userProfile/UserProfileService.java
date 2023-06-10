package hobbyloop.backend.domain.userProfile;

import javax.persistence.EntityExistsException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hobbyloop.backend.domain.user.User;
import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserProfileService {
	private final UserProfileRepository userProfileRepository;

	@Transactional
	public UserProfile createUserProfile(UserProfile userProfile) {
		return userProfileRepository.save(userProfile);
	}

	public UserProfile findUserProfileByUser(User user) {
		return userProfileRepository.findByUser(user).orElseThrow(EntityExistsException::new);
	}

	@Transactional
	public void updateUserProfile(UserProfile userProfile) {
		userProfileRepository.save(userProfile);
	}
}
