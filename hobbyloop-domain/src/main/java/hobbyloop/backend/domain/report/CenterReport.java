package hobbyloop.backend.domain.report;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import hobbyloop.backend.domain.center.Center;

@Entity
public class CenterReport extends Report {

	@ManyToOne
	@JoinColumn(name = "centerId")
	private Center center;
}
