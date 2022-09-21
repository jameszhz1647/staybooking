package com.jameszhz.staybooking.model;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Embeddable
public class StayReservedDateKey implements Serializable { //与db交互，需要serializable
    private static final long serialVersionUID = 1L;
    private Long stay_id;
    private LocalDate date;

    public StayReservedDateKey() {} // for hibernate used to convert db to obj

    public StayReservedDateKey(Long stay_id, LocalDate date) {
        this.stay_id = stay_id;
        this.date = date;
    }

    public Long getStay_id() {
        return stay_id;
    }

    public StayReservedDateKey setStay_id(Long stay_id) {
        this.stay_id = stay_id;
        return this;
    }

    public LocalDate getDate() {
        return date;
    }

    public StayReservedDateKey setDate(LocalDate date) {
        this.date = date;
        return this;
    }

    //primary key需要比较，需重写equals()，hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StayReservedDateKey that = (StayReservedDateKey) o;
        return stay_id.equals(that.stay_id) && date.equals(that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stay_id, date);
    }
}
