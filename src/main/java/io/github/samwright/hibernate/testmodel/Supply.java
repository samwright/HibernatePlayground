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
@Table(name = "SUPPLY")
public class Supply implements Serializable {

    @Column(name = "S_ID") @Id
    private String supplierID;

    @Column(name = "P_ID") @Id
    private String partID;

    @Column(name = "J_ID") @Id
    private String projectID;

    @OneToOne
    @JoinColumn(name = "S_ID")
    @Getter @Setter
    private Supplier supplier;

    @OneToOne
    @JoinColumn(name = "P_ID")
    @Getter @Setter
    private Part part;

    @OneToOne
    @JoinColumn(name = "J_ID")
    @Getter @Setter
    private Project project;

    @Column(name = "QUANTITY")
    @Getter @Setter
    private int quantity;
}
