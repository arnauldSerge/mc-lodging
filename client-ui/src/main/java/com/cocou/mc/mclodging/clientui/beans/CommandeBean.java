package com.cocou.mc.mclodging.clientui.beans;

import java.time.LocalDateTime;

import lombok.Data;
@Data
public class CommandeBean {
    private Long id;
    private Long productId;
    //private int quantity;
    //private double totalPrice;
    
    //private int id;

   // private Integer productId;

    private LocalDateTime dateCommande;

    private Integer quantite;

    private Boolean commandePayee;
}
