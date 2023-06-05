package hobbyloop.backend.domain.center;

import java.util.Arrays;

import hobbyloop.backend.domain.exception.enumbinding.enumtype.CenterSortTypeBindingException;
import lombok.Getter;

@Getter
public enum CenterSortType {
	RECENTLY("recently"),
	AMOUNT("amount"),
	SCORE("score"),
	REVIEW("review");

	private final String sortType;

	CenterSortType(String sortType) {
		this.sortType = sortType;
	}

	public static CenterSortType of(String searchType) {
		return Arrays.stream(CenterSortType.values())
			.filter(centerSortType -> centerSortType.getSortType().equals(searchType))
			.findAny().orElseThrow(CenterSortTypeBindingException::new);
	}
}
