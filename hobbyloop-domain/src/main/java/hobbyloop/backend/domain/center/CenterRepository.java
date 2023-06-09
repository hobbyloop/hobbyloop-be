package hobbyloop.backend.domain.center;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import hobbyloop.backend.domain.ticket.TicketType;
import hobbyloop.backend.domain.user.User;

@Repository
public interface CenterRepository extends JpaRepository<Center, Long> {

	Optional<Center> findByUser(User user);

	@Query((
		"SELECT new hobbyloop.backend.domain.center.CenterDTO(c.centerId, c.centerName, c.repImageUrl, c.address, c.score, COUNT(t), CASE WHEN cb.center IS NULL THEN false ELSE true END) "
			+
			"FROM Center c " +
			"JOIN c.tickets t " +
			"LEFT OUTER JOIN CenterBookmark cb ON cb.center = c AND cb.user = :user " +
			"WHERE t.ticketType = :ticketType " +
			"GROUP BY c " +
			"ORDER BY c.reviewCount DESC"))
	List<CenterDTO> findCentersWithDTOOrderByReviewCountDesc(@Param("ticketType") TicketType ticketType,
		@Param("user") User user, Pageable pageable);

	@Query((
		"SELECT new hobbyloop.backend.domain.center.CenterDTO(c.centerId, c.centerName, c.repImageUrl, c.address, c.score, COUNT(t), CASE WHEN cb.center IS NULL THEN false ELSE true END) "
			+
			"FROM Center c " +
			"JOIN c.tickets t " +
			"LEFT OUTER JOIN CenterBookmark cb ON cb.center = c AND cb.user = :user " +
			"WHERE t.ticketType = :ticketType " +
			"GROUP BY c " +
			"ORDER BY c.amount DESC"))
	List<CenterDTO> findCentersWithDTOOrderByAmountDesc(@Param("ticketType") TicketType ticketType,
		@Param("user") User user, Pageable pageable);

	@Query((
		"SELECT new hobbyloop.backend.domain.center.CenterDTO(c.centerId, c.centerName, c.repImageUrl, c.address, c.score, COUNT(t), CASE WHEN cb.center IS NULL THEN false ELSE true END) "
			+
			"FROM Center c " +
			"JOIN c.tickets t " +
			"LEFT OUTER JOIN CenterBookmark cb ON cb.center = c AND cb.user = :user " +
			"WHERE t.ticketType = :ticketType " +
			"GROUP BY c " +
			"ORDER BY c.score DESC"))
	List<CenterDTO> findCentersWithDTOOrderByScoreDesc(@Param("ticketType") TicketType ticketType,
		@Param("user") User user, Pageable pageable);

	@Query((
		"SELECT new hobbyloop.backend.domain.center.CenterDTO(c.centerId, c.centerName, c.repImageUrl, c.address, c.score, COUNT(t), CASE WHEN cb.center IS NULL THEN false ELSE true END) "
			+
			"FROM Center c " +
			"JOIN c.tickets t " +
			"LEFT OUTER JOIN CenterBookmark cb ON cb.center = c AND cb.user = :user " +
			"WHERE t.ticketType = :ticketType " +
			"GROUP BY c " +
			"ORDER BY c.createdTime Desc"))
	List<CenterDTO> findCentersWithDTOOrderByCreatedTimeDesc(@Param("ticketType") TicketType ticketType,
		@Param("user") User user, Pageable pageable);

	@Query((
		"SELECT new hobbyloop.backend.domain.center.CenterDTO(c.centerId, c.centerName, c.repImageUrl, c.address, c.score, COUNT(t), CASE WHEN cb.center IS NULL THEN false ELSE true END) "
			+
			"FROM Center c " +
			"JOIN c.tickets t " +
			"LEFT OUTER JOIN CenterBookmark cb ON cb.center = c AND cb.user = :user " +
			"WHERE t.ticketType = :ticketType " +
			"GROUP BY c " +
			"ORDER BY FUNCTION('ST_DISTANCE', POINT(c.mapx, c.mapy), POINT(:mapx, :mapy)) ASC, t.score DESC"))
	List<CenterDTO> findCentersWithDTOOrderByDistanceDesc(
		@Param("ticketType") TicketType ticketType, @Param("user") User user,
		@Param("mapx") double mapx, @Param("mapy") double mapy, Pageable pageable);

}
