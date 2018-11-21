package com.niit.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
public class Product
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
   private int id;
   @NotEmpty(message="Productname is mandatory") private String productname;
   @NotEmpty(message="ProductDesc is required") private String productdesc;
  @Min(value=0,message="Minimum Quantity must be 1") private int quantity;
  @Min(value=1,message="Minimum Price must be 1") private double price;
  
  @ManyToOne
  private Category category;
public int getId() {
	return id;
}

public Category getCategory() {
	return category;
}

public void setCategory(Category category) {
	this.category = category;
}

public void setId(int id) {
	this.id = id;
}
public String getProductname() {
	return productname;
}
public void setProductname(String productname) {
	this.productname = productname;
}

public String getProductdesc() {
	return productdesc;
}

public void setProductdesc(String productdesc) {
	this.productdesc = productdesc;
}

public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
}
