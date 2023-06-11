package hobbyloop.backend.domain.userProfile;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import hobbyloop.backend.domain.ticket.TicketType;
import hobbyloop.backend.domain.user.User;
import hobbyloop.backend.domain.user.UserStatus;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class UserProfile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userProfileId;

	@OneToOne
	private User user;

	@Enumerated(value = EnumType.STRING)
	private UserStatus userStatus;

	@Enumerated(value = EnumType.STRING)
	private Gender gender;

	@Enumerated(value = EnumType.STRING)
	private TicketType ticketType;

	private String name;

	private String nickname;

	private LocalDate birth;

	private String phoneNum;

	private String account;

	private int chargedPoint;

	private int givenPoint;

	public void changeDefaultTicketType(TicketType defaultTicketType) {
		this.ticketType = defaultTicketType;
	}
}
