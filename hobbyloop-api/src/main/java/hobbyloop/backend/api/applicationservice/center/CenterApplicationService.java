package hobbyloop.backend.api.applicationservice.center;

import static hobbyloop.backend.api.controller.util.Constant.*;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import hobbyloop.backend.api.controller.center.dto.CenterListResponseDTO;
import hobbyloop.backend.api.controller.center.dto.CenterTypeDTO;
import hobbyloop.backend.domain.center.CenterDTO;
import hobbyloop.backend.domain.center.CenterService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CenterApplicationService {

	private final CenterService centerService;

	public List<CenterListResponseDTO> getCentersWithRanking(String email, String ticketType, String sortType,
		Pageable pageable) {
		List<CenterDTO> centers = centerService.getCentersWithRanking(email, ticketType, sortType, pageable);
		return centers.stream()
			.map(CenterListResponseDTO::from)
			.collect(Collectors.toList());

	}

	public List<CenterListResponseDTO> getCentersWithDistance(String email, String ticketType, double mapx, double mapy,
		Pageable pageable) {
		List<CenterDTO> centers = centerService.getCentersWithDistance(email, ticketType, mapx, mapy, pageable);
		return centers.stream()
			.map(CenterListResponseDTO::from)
			.collect(Collectors.toList());
	}

	public List<CenterTypeDTO> getCenterTypeList() {
		return CENTER_LOGO_AND_LIST.stream()
			.map(CenterTypeDTO::new)
			.collect(Collectors.toList());
	}
}
