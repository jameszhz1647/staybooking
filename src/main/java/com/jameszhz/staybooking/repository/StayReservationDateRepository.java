package com.jameszhz.staybooking.repository;

import com.jameszhz.staybooking.model.StayReservedDate;
import com.jameszhz.staybooking.model.StayReservedDateKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Repository
public interface StayReservationDateRepository extends JpaRepository<StayReservedDate, StayReservedDateKey> { //<pk, type of pk>
    //jpa 没有实现，需自己写SQL Query
    @Query(value =
            "SELECT srd.id.stay_id FROM StayReservedDate srd WHERE srd.id.stay_id IN ?1 AND srd.id.date BETWEEN ?2 AND ?3 GROUP BY srd.id.stay_id"
    )
    Set<Long> findByIdInAndDateBetween(List<Long> stayIds, LocalDate startDate, LocalDate endDate);  //stayID 和 locationID （from elasticSearch）相同
    //返回已经被预订的  a list of stay_ids
}
