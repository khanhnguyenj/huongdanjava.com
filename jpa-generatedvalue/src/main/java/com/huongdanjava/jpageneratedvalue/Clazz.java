package com.huongdanjava.jpageneratedvalue;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.engine.transaction.internal.TransactionImpl;
import org.hibernate.event.internal.AbstractSaveEventListener;

@Entity
@Table
@Getter
@Setter
public class Clazz {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_gen")
    @SequenceGenerator(name = "sequence_gen", sequenceName = "sequence", allocationSize = 3)
    private Long id;

    @Column
    private String name;
}