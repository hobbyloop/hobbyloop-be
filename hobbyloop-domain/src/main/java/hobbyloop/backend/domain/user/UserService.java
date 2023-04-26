package hobbyloop.backend.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Optional<User> getUserByRefreshToken(String refreshToken) {
        return userRepository.findByRefreshToken(refreshToken);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> getUserBySocialTypeAndSocialId(SocialType socialType, String id) {
        return userRepository.findBySocialTypeAndSocialId(socialType, id);
    }
}
