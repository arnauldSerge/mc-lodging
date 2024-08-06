package com.cocou.mc.mclodging.clientui.beans;

import lombok.Data;

@Data
public class ProductBean {
	private Long id;
	private String titre;
	private String description;
	private String image;
	private Double prix;
}
