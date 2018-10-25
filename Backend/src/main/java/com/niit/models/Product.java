package com.niit.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
public class Product
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
   private int id;
   @NotEmpty(message="Productname is mandatory") private String productname;
   @NotEmpty(message="Productname is required") private String productDesc;
  @Min(value=0,message="Minimum Quantity must be 0") 
  private int quantity;
  @Min(value=1,message="Minimum Quantity must be 1")
   private double price;
public int getId() {
	return id;
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
public String getProductDesc() {
	return productDesc;
}
public void setProductDesc(String productDesc) {
	this.productDesc = productDesc;
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
