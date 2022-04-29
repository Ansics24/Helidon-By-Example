package de.schulte.smartbar.backoffice.categories;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import de.schulte.smartbar.backoffice.SmartbarEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="categories")
public class Category extends SmartbarEntity {

    @Column(name = "name")
    private String name;
}
