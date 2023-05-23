package hobbyloop.backend.domain.ticket;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum TicketType {
    GYM("헬스/PT"),
    PILATES("필라테스"),
    DANCE("댄스"),
    GOLF("골프");

    private final String name;

    TicketType(String name) {
        this.name = name;
    }

    public static TicketType of(String ticketType) {
        return Arrays.stream(TicketType.values())
                .filter(ticket -> ticket.getName().equals(ticketType))
                .findAny().orElseThrow(NoSuchFieldError::new);
    }
}
