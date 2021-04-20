package com.clover.poedash.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "players")
public class Player {

    @Id
    private Long Id;
    private String accountName;

}
