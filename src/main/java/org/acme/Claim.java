package org.acme;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Claim extends PanacheEntity {

    public String claimNumber;
    public String clientName;
    @Column(length = 5000)
    public String summary;

    public static Claim findClaimByNumber(String claimNumber) {
        return Claim.find("claimNumber", claimNumber).firstResult();
    }

}
