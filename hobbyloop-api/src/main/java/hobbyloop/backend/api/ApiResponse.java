package hobbyloop.backend.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)  //JSON 형식 변환시 필요한 어노테이션 + 직접 클래스를 생성하는 것을 막음
@JsonInclude(JsonInclude.Include.NON_NULL)  // null 인 값은 표시하지 않음
@AllArgsConstructor
public class ApiResponse<T> {

    private int status;
    private T data;

    public static <T> ApiResponse<T> success(HttpStatus httpStatus) {
        return new ApiResponse<>(httpStatus.value(), null);
    }

    public static <T> ApiResponse<T> success(HttpStatus httpStatus, T data) {
        return new ApiResponse<>(httpStatus.value(), data);
    }

}
