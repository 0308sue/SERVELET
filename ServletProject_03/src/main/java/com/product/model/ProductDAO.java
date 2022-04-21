package com.product.model;

import java.util.ArrayList;

public interface ProductDAO {
 public void productInsert(Product product);
 
 public ArrayList<Product> productAllfind();
 
 public Product findById (Long productId); 
}
