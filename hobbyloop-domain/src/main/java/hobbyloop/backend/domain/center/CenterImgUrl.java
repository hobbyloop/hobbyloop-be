package hobbyloop.backend.domain.center;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CenterImgUrl {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long centerImgUrlId;

	@ManyToOne
	@JoinColumn(name = "centerId")
	private Center center;

	private String imgUrl;
}
