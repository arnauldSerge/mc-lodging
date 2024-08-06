package com.cocou.mc.mclodging.clientui.beans;

import lombok.Data;

@Data
public class PaiementBean {
	private int id;

    private Integer idCommande;

    private Double montant;

    private Long numeroCarte;
}
