package hobbyloop.backend.api.controller.center.dto;

import java.util.List;

import lombok.Getter;

@Getter
public class CenterTypeDTO {

	private String categoryLogo;
	private String categoryName;

	public CenterTypeDTO(List<String> categoryType) {
		this.categoryLogo = categoryType.get(0);
		this.categoryName = categoryType.get(1);
	}
}
