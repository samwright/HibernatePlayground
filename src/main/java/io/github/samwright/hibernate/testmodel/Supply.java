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
@Table(name = "SUPPLY")
public class Supply implements Serializable {

    @Column(name = "S_ID") @Id
    @Getter @Setter
    private String supplierID;

    @Column(name = "P_ID") @Id
    @Getter @Setter
    private String partID;

    @Column(name = "J_ID") @Id
    @Getter @Setter
    private String projectID;

    @Column(name = "QUANTITY")
    @Getter @Setter
    private int quantity;
}
