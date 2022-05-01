package de.schulte.smartbar.backoffice.tables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import de.schulte.smartbar.backoffice.SmartbarEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "smartbar_table")
public class SmartbarTable extends SmartbarEntity {

    @Column(name = "name")
    private String name;

}
