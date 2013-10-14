package io.github.samwright.hibernate.testmodel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * User: Sam Wright Date: 14/10/2013 Time: 14:00
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "SUPPLIER")
public class Supplier implements Serializable {

    @Column(name = "S_ID") @Id
    @Getter @Setter
    private String id;

    @Column(name = "SNAME")
    @Getter @Setter
    private String name;

    @Column(name = "STATUS")
    @Getter @Setter
    private int status;

    @Column(name = "CITY")
    @Getter @Setter
    private String city;
}
