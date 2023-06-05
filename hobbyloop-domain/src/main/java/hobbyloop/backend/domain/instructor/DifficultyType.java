package hobbyloop.backend.domain.instructor;

import lombok.Getter;

@Getter
public enum DifficultyType {
	EASY("초급"),
	NORMAL("초급"),
	HARD("초급");

	private final String difficulty;

	DifficultyType(String difficulty) {
		this.difficulty = difficulty;
	}
}
