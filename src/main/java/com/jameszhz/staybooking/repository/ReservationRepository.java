package com.jameszhz.staybooking.repository;

import com.jameszhz.staybooking.model.Reservation;
import com.jameszhz.staybooking.model.Stay;
import com.jameszhz.staybooking.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    //非by pk 的 method，需额外添加 （符合naming convention spring会自动实现）
    List<Reservation> findByGuest(User guest);

    List<Reservation> findByStay(Stay stay);

    Reservation findByIdAndGuest(Long id, User guest); // for deletion

    List<Reservation> findByStayAndCheckoutDateAfter(Stay stay, LocalDate date);
}