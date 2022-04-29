package de.schulte.smartbar.backoffice;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Data;

@MappedSuperclass
@Data
public abstract class SmartbarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "smartbar_sequence")
    private Integer id;
}
