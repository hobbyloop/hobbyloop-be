package hobbyloop.backend.domain.center;

import javax.persistence.*;

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
