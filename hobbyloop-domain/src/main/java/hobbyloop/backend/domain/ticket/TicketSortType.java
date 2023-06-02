package hobbyloop.backend.domain.ticket;

import hobbyloop.backend.domain.exception.enumbinding.EnumTypeBindingException;
import hobbyloop.backend.domain.exception.enumbinding.enumtype.TicketSortTypeBindingException;
import lombok.Getter;

import java.util.Arrays;

@Getter
public enum TicketSortType {
    RECENTLY("recently"),
    AMOUNT("amount"),
    SCORE("score");

    private final String sortType;

    TicketSortType(String sortType) {
        this.sortType = sortType;
    }

    public static TicketSortType of(String searchType) {
        return Arrays.stream(TicketSortType.values())
                .filter(ticketSortType -> ticketSortType.getSortType().equals(searchType))
                .findAny().orElseThrow(TicketSortTypeBindingException::new);
    }
}
