package hobbyloop.backend.domain.ticket;

import hobbyloop.backend.domain.BaseTime;
import hobbyloop.backend.domain.center.Center;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Ticket extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticketId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "centerId")
    private Center center;

    @Enumerated(value = EnumType.STRING)
    private TicketType ticketType;

    private String keyword;
    private int price;
    private int days;
    private int salesAmount;
    private double score;
}
