package hobbyloop.backend.domain.userProfile;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum Gender {
    MAN("남자"),
    WOMAN("여자");

    private final String name;

    Gender(String name) {
        this.name = name;
    }

    public static Gender of(String name) {
        return Arrays.stream(Gender.values())
                .filter(gender -> gender.getName().equals(name))
                .findAny().orElseThrow(IllegalAccessError::new);
    }
}
