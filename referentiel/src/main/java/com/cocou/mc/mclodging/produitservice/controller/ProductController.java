package com.cocou.mc.mclodging.produitservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cocou.mc.mclodging.produitservice.dao.ProductDao;
import com.cocou.mc.mclodging.produitservice.exceptions.ProductNotFoundException;
import com.cocou.mc.mclodging.produitservice.model.Product;

@RestController
@RequestMapping("api/products")
public class ProductController {

  private final ProductDao productDao;

  public ProductController(ProductDao productDao){
      this.productDao = productDao;
  }
 
  // Affiche la liste de tous les produits disponibles
  @GetMapping
  public List<Product> listeDesProduits(){

      List<Product> products = productDao.findAll();

      if(products.isEmpty()) throw new ProductNotFoundException("Aucun produit n'est disponible à la vente");

      return products;

  }

  //Récuperer un produit par son id
  @GetMapping( value = "/{id}")
  public Optional<Product> recupererUnProduit(@PathVariable Long id) {

      Optional<Product> product = productDao.findById(id);

      if(!product.isPresent())  throw new ProductNotFoundException("Le produit correspondant à l'id " + id + " n'existe pas");

      return product;
  }
}
