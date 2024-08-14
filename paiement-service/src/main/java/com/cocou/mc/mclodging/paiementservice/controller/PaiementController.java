package com.cocou.mc.mclodging.paiementservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cocou.mc.mclodging.paiementservice.dao.PaiementDao;
import com.cocou.mc.mclodging.paiementservice.exception.PaiementExistantException;
import com.cocou.mc.mclodging.paiementservice.exception.PaiementImpossibleException;
import com.cocou.mc.mclodging.paiementservice.model.Paiement;

@RestController
@RequestMapping("api/paiements")
@RefreshScope
public class PaiementController {
	@Autowired
	PaiementDao paiementDao;

	@PostMapping//(value = "")
	public ResponseEntity<Paiement>  payerUneCommande(@RequestBody Paiement paiement){


		//Vérifions s'il y a déjà un paiement enregistré pour cette commande
		Paiement paiementExistant = paiementDao.findByidCommande(paiement.getIdCommande());
		if(paiementExistant != null) throw new PaiementExistantException("Cette commande est déjà payée");

		//Enregistrer le paiement
		Paiement nouveauPaiement = paiementDao.save(paiement);


		if(nouveauPaiement == null) throw new PaiementImpossibleException("Erreur, impossible d'établir le paiement, réessayez plus tard");



		//TODO Nous allons appeler le Microservice Commandes ici pour lui signifier que le paiement est accepté

		return new ResponseEntity<Paiement>(nouveauPaiement, HttpStatus.CREATED);
	}
}
