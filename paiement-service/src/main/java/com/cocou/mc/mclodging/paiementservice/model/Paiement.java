package com.cocou.mc.mclodging.paiementservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Paiement {
	@Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private Long idCommande;

    private Integer montant;

    private Long numeroCarte;
}
