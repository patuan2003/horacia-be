package com.horacia.server.entity;


import com.horacia.server.util.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "water_resistances")
public class WaterResistance extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;

    @Column(name = "level")
    private String level;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

}
