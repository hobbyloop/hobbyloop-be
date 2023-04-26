package hobbyloop.backend.api.infra.global.jwt.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;

@Slf4j
public class PasswordUtil {

    public static String generateRandomPassword() {
        String password = RandomStringUtils.randomAlphanumeric(10);

        log.info("생성 된 비밀번호 : {}", password);
        return password;
    }
}
