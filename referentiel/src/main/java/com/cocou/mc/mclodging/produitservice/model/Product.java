package com.cocou.mc.mclodging.produitservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
@Entity
@Data
public class Product {
	@Id
	@GeneratedValue
	private int id;
	private String titre;
	private String description;
	private String image;

	private Double prix;
}
