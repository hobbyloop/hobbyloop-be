package hobbyloop.backend.domain.coupon;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hobbyloop.backend.domain.user.User;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, Long> {

	List<Coupon> findAllByUserAndCouponStatus(User user, CouponStatus couponStatus);
}
