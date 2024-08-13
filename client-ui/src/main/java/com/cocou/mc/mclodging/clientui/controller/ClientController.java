package com.cocou.mc.mclodging.clientui.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cocou.mc.mclodging.clientui.beans.CommandeBean;
import com.cocou.mc.mclodging.clientui.beans.PaiementBean;
import com.cocou.mc.mclodging.clientui.beans.ProductBean;
import com.cocou.mc.mclodging.clientui.proxies.MicroserviceCommandeProxy;
import com.cocou.mc.mclodging.clientui.proxies.MicroservicePaiementProxy;
import com.cocou.mc.mclodging.clientui.proxies.MicroserviceProduitsProxy;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class ClientController {

	private final MicroserviceProduitsProxy produitsProxy;

	private final MicroserviceCommandeProxy CommandesProxy;

	private final MicroservicePaiementProxy paiementProxy;

	@GetMapping("/")
	public String accueil(Model model)
	{
		List<ProductBean> produits =  produitsProxy.listeDesProduits();
		model.addAttribute("produits", produits);
		return "Accueil";
	}

	@GetMapping("/details-produit/{id}")
	public String ficheProduit(@PathVariable int id,  Model model){
		ProductBean produit = produitsProxy.recupererUnProduit(id);
		model.addAttribute("produit", produit);
		return "FicheProduit";
	}



	/*
	 * Étape (3) et (4)
	 * Opération qui fait appel au microservice de commande pour placer une commande et récupérer les détails de la commande créée
	 * */
	@GetMapping("/commander-produit/{idProduit}/{montant}")
	public String passerCommande(@PathVariable Long idProduit, @PathVariable Double montant,  Model model){


		CommandeBean commande = new CommandeBean();

		//On renseigne les propriétés de l'objet de type CommandeBean que nous avons crée
		commande.setProductId(idProduit);
		commande.setQuantite(1);
		commande.setDateCommande( LocalDateTime.now());
		//appel du microservice commandes grâce à Feign et on récupère en retour les détails de la commande créée, notamment son ID (étape 4).
		CommandeBean commandeAjoutee = CommandesProxy.ajouterCommande(commande);
		//on passe à la vue l'objet commande et le montant de celle-ci afin d'avoir les informations nécessaire pour le paiement
		model.addAttribute("commande", commandeAjoutee);
		model.addAttribute("montant", montant);
		return "Paiement";
	}

	/*
	 * Étape (5)
	 * Opération qui fait appel au microservice de paiement pour traiter un paiement
	 * */
	@GetMapping("/payer-commande/{idCommande}/{montantCommande}")
	public String payerCommande(@PathVariable int idCommande, @PathVariable Double montantCommande, Model model){

		PaiementBean paiementAExcecuter = new PaiementBean();

		//on reseigne les détails du produit
		paiementAExcecuter.setIdCommande(idCommande);
		paiementAExcecuter.setMontant(montantCommande);
		paiementAExcecuter.setNumeroCarte(numcarte()); // on génère un numéro au hasard pour simuler une CB

		// On appel le microservice et (étape 7) on récupère le résultat qui est sous forme ResponseEntity<PaiementBean> ce qui va nous permettre de vérifier le code retour.
		ResponseEntity<PaiementBean> paiement = paiementProxy.payerUneCommande(paiementAExcecuter);

		Boolean paiementAccepte = false;
		//si le code est autre que 201 CREATED, c'est que le paiement n'a pas pu aboutir.
		if(paiement.getStatusCode() == HttpStatus.CREATED)
			paiementAccepte = true;

		model.addAttribute("paiementOk", paiementAccepte); // on envoi un Boolean paiementOk à la vue

		return "Confirmation";
	}

	//Génére une serie de 16 chiffres au hasard pour simuler vaguement une CB
	private Long numcarte() {

		return ThreadLocalRandom.current().nextLong(1000000000000000L,9000000000000000L );
	}



}