package com.clover.poedash.model;



import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Match {
    @Id
    private Long id; //rank
    private String account;
    private String character;
    private String characterClass;
    private Integer level;
    private Long experience;
    private Boolean dead;
}
