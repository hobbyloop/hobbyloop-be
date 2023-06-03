package hobbyloop.backend.api.controller.center;

import hobbyloop.backend.api.applicationservice.center.CenterApplicationService;
import hobbyloop.backend.api.controller.center.dto.CenterDistanceListRequestDTO;
import hobbyloop.backend.api.controller.center.dto.CenterListResponseDTO;
import hobbyloop.backend.api.controller.center.dto.CenterRankingListRequestDTO;
import hobbyloop.backend.api.infra.util.ApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static hobbyloop.backend.api.controller.util.Constant.CENTER_LOGO_AND_LIST;

@Api(tags = {"업체 관련 API 정보를 제공하는 Controller 입니다."})
@RestController
@RequestMapping("/api/v1/center")
@RequiredArgsConstructor
public class CenterController {
    private final CenterApplicationService centerApplicationService;

    @ApiOperation(value = "업체 리스트 랭킹순으로 조회",
            notes = "ticketType : Figma 내의 이용권 카테고리 그대로 설정 && sortType(정렬기준) : recently(=최신순), amount(=판매량순), score(=평점순)")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "페이지 번호", dataTypeClass = Integer.class),
            @ApiImplicitParam(name = "size", value = "페이지당 데이터 개수", dataTypeClass = Integer.class)
    })
    @GetMapping("/list/ranking")
    public ApiResponse<List<CenterListResponseDTO>> getCentersWithRanking(
            @RequestBody CenterRankingListRequestDTO centerRankingListRequestDTO,
            Pageable pageable
    ) {
        return ApiResponse.success(HttpStatus.OK,
                centerApplicationService.getCentersWithRanking(
                        centerRankingListRequestDTO.getUserId(),
                        centerRankingListRequestDTO.getTicketType(),
                        centerRankingListRequestDTO.getSortType(), pageable));
    }

    @ApiOperation(value = "이용권 리스트 거리순으로 조회",
            notes = "ticketType : Figma 내의 이용권 카테고리 그대로 설정")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "페이지 번호", dataTypeClass = Integer.class),
            @ApiImplicitParam(name = "size", value = "페이지당 데이터 개수", dataTypeClass = Integer.class)
    })
    @GetMapping("/list/distance")
    public ApiResponse<List<CenterListResponseDTO>> getTicketsWithDistance(
            @RequestBody CenterDistanceListRequestDTO centerDistanceListRequestDTO,
            Pageable pageable
    ) {
        return ApiResponse.success(HttpStatus.OK,
                centerApplicationService.getCentersWithDistance(
                        centerDistanceListRequestDTO.getUserId(),
                        centerDistanceListRequestDTO.getTicketType(),
                        centerDistanceListRequestDTO.getMapx(),
                        centerDistanceListRequestDTO.getMapy(), pageable));
    }

    @ApiOperation(value = "센터 카테고리 목록 조회")
    @GetMapping("/type/list")
    public ApiResponse<List<List<String>>> getCenterTypeList() {
        return ApiResponse.success(HttpStatus.OK, CENTER_LOGO_AND_LIST);
    }
}
