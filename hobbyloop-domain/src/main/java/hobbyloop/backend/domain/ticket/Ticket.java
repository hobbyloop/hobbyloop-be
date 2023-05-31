package hobbyloop.backend.domain.ticket;

import hobbyloop.backend.domain.BaseTime;
import hobbyloop.backend.domain.center.Center;
import hobbyloop.backend.domain.instructor.Instructor;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Ticket extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticketId;

    @ManyToOne
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