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
@Table(name = "PROJECT")
public class Project implements Serializable {

    @Column(name = "J_ID") @Id
    @Getter @Setter
    private String id;

    @Column(name = "JNAME")
    @Getter @Setter
    private String name;

    @Column(name = "CITY")
    @Getter @Setter
    private String city;
}
