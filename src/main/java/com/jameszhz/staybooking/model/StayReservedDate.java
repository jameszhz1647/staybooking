package com.jameszhz.staybooking.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "stay_reserved_date")
public class StayReservedDate implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId  // the pk is embedded with stay_id and date
    private StayReservedDateKey id;

    @MapsId("stay_id") // ref to stay_id from StayReservedDateKey -> as the foreign key in this table
    @ManyToOne
    private Stay stay;

    public StayReservedDate() {}

    public StayReservedDate(StayReservedDateKey id, Stay stay) {
        this.id = id;
        this.stay = stay;
    }

    public StayReservedDateKey getId() {
        return id;
    }

    public Stay getStay() {
        return stay;
    }
}
