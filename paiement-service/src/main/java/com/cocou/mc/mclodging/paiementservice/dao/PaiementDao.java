package com.cocou.mc.mclodging.paiementservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cocou.mc.mclodging.paiementservice.model.Paiement;

@Repository
public interface PaiementDao extends JpaRepository<Paiement, Long>{

    Paiement findByidCommande(Long idCommande);
}
