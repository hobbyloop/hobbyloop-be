package hobbyloop.backend.domain.center;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import hobbyloop.backend.domain.BaseTime;
import hobbyloop.backend.domain.instructor.Instructor;
import hobbyloop.backend.domain.ticket.Ticket;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Center extends BaseTime {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long centerId;

	private String centerName;

	private String address;

	private String kakaoLinkUrl;

	private int mapx;

	private int mapy;

	private int amount;

	private int reviewCount;

	private double score;

	private String repImageUrl;

	private String centerIntroduction;

	private String facilityIntroduction;

	private String counselingAvailableTime;

	@OneToMany(mappedBy = "center")
	private List<Ticket> tickets = new ArrayList<>();

	@OneToMany(mappedBy = "center")
	private List<Instructor> instructors = new ArrayList<>();
}
