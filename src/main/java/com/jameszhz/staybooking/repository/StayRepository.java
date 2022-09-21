package com.jameszhz.staybooking.repository;

import com.jameszhz.staybooking.model.Stay;
import com.jameszhz.staybooking.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StayRepository extends JpaRepository<Stay, Long> {
    //JpaRepository默认只能对主键操作，对其他key操作需要另加method（这些转SQL的method springframework.data会自动实现）
    List<Stay> findByHost(User user); //命名匹配，

    Stay findByIdAndHost(Long id, User host);   //access control, only return the specific stay

    List<Stay> findByIdInAndGuestNumberGreaterThanEqual(List<Long> ids, int guestNumber);

}
