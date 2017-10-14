package com.huongdanjava.jpaonetoone;

import javax.persistence.*;

@Entity
@Table
public class Tourist {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String name;

    @OneToOne
    @JoinColumn(name = "room_id")
    private Room room;

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

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
