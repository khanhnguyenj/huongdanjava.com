package com.huongdanjava.jpaonetoone;

import javax.persistence.*;

@Table
@Entity
public class Room {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String name;

    @Column
    private String hotel;

    @OneToOne(mappedBy = "room")
    private Tourist tourist;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public Tourist getTourist() {
        return tourist;
    }

    public void setTourist(Tourist tourist) {
        this.tourist = tourist;
    }
}
