package hobbyloop.backend.domain.report;

import hobbyloop.backend.domain.center.Center;

import javax.persistence.*;

@Entity
public class CenterReport extends Report {

    @ManyToOne
    @JoinColumn(name = "centerId")
    private Center center;
}
