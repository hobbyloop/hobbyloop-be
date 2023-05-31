package hobbyloop.backend.api.controller.ticket;

import hobbyloop.backend.api.applicationservice.ticket.TicketApplicationService;
import hobbyloop.backend.api.controller.ticket.dto.GetTicketListResponseDTO;
import hobbyloop.backend.api.infra.util.ApiResponse;
import hobbyloop.backend.domain.ticket.TicketSortType;
import hobbyloop.backend.domain.ticket.TicketType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = {"이용권 API 정보를 제공하는 Controller 입니다."})
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/ticket")
public class TicketController {

    private final TicketApplicationService ticketApplicationService;

    @ApiOperation(value = "이용권 리스트 랭킹순으로 조회",
            notes = "ticketType : Figma 내의 이용권 카테고리 그대로 설정 && sortType(정렬기준) : recently(=최신순), amount(=판매량순), score(=평점순)")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ticketType", value = "이용권의 카테고리", dataType = "String", dataTypeClass = TicketType.class),
            @ApiImplicitParam(name = "sortType", value = "정렬기준", dataType = "String", dataTypeClass = TicketSortType.class),
            @ApiImplicitParam(name = "page", value = "페이지 번호", dataTypeClass = Integer.class),
            @ApiImplicitParam(name = "size", value = "페이지당 데이터 개수", dataTypeClass = Integer.class)
    })
    @GetMapping("/list/ranking")
    public ApiResponse<List<GetTicketListResponseDTO>> getTicketsWithRanking(
            @RequestParam String ticketType,
            @RequestParam String sortType,
            Pageable pageable
    ) {
        return ApiResponse.success(HttpStatus.OK,
                ticketApplicationService.getTicketsWithRanking(ticketType, sortType, pageable));
    }

    @ApiOperation(value = "이용권 리스트 거리순으로 조회",
            notes = "ticketType : Figma 내의 이용권 카테고리 그대로 설정")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ticketType", value = "이용권의 카테고리", dataType = "String", dataTypeClass = TicketType.class),
            @ApiImplicitParam(name = "mapx", value = "경도", dataTypeClass = Integer.class),
            @ApiImplicitParam(name = "mapy", value = "위도", dataTypeClass = Integer.class),
            @ApiImplicitParam(name = "page", value = "페이지 번호", dataTypeClass = Integer.class),
            @ApiImplicitParam(name = "size", value = "페이지당 데이터 개수", dataTypeClass = Integer.class)
    })
    @GetMapping("/list/distance")
    public ApiResponse<List<GetTicketListResponseDTO>> getTicketsWithDistance(
            @RequestParam String ticketType,
            @RequestParam double mapx,
            @RequestParam double mapy,
            Pageable pageable
    ) {
        return ApiResponse.success(HttpStatus.OK,
                ticketApplicationService.getTicketsWithDistance(ticketType, mapx, mapy, pageable));
    }
}
