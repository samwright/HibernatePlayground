package io.github.samwright.hibernate.testmodel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * User: Sam Wright Date: 14/10/2013 Time: 14:00
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PART")
public class Part implements Serializable {

    @Column(name = "P_ID") @Id
    @Getter @Setter
    private String id;

    @Column(name = "PNAME")
    @Getter @Setter
    private String name;

    @Column(name = "COLOUR")
    @Getter @Setter
    private String colour;

    @Column(name = "WEIGHT")
    @Getter @Setter
    private int weight;

    @Column(name = "CITY")
    @Getter @Setter
    private String city;
}
