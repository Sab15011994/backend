package com.niit.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.models.Product;
import com.niit.services.ProductService;


@Controller
public class ProductController {

	@Autowired
	private ProductService productService;
	public ProductController()
	{
		System.out.println("Product Controller bean is created");
	}

	@RequestMapping(value = "/all/getallproducts")
	public String getAllProducts(Model model) {
		List <Product> products =  productService.getAllProducts();
		model.addAttribute("products", products);
		return "listofproducts";
	}

	@RequestMapping(value = "/all/getproduct")
	public String getProduct(@RequestParam int id, Model model) {
		Product product = productService.getProduct(id);
		model.addAttribute("productAttr", product);
		return "viewproduct";
	}

	@RequestMapping(value="/admin/deleteproduct")
	public String deleteProduct(@RequestParam int id) {
		productService.deleteProduct(id);
		return "redirect:/all/getallproducts";
	}

	@RequestMapping(value = "/admin/getproductform")
	public String getProductForm(Model model) {
		Product p = new Product();
		model.addAttribute("product", p);
		return "productform";
	}

	@RequestMapping(value = "/admin/addproduct")
	public String addproduct(@ Valid @ModelAttribute Product product ,BindingResult result) {
		productService.addProduct(product);
		if(result.hasErrors())
		{
			return "productform";
		}
		productService.addProduct(product);
		return "redirect:/all/getallproducts";
	}
	@RequestMapping(value = "/admin/getupdateproductform")
	public String getUpdateProductForm(@RequestParam int id, Model model) {
		Product product = productService.getProduct(id);
		model.addAttribute("product", product);
		return "updateproductform";
	}
	@RequestMapping(value = "/admin/updateproduct")
	public String updateProduct (@ Valid @ModelAttribute Product product ,BindingResult result) {
		if(result.hasErrors()) {
			return "updateproductform";
		}
		productService.updateProduct(product);
		return "redirect:/all/getallproducts";
	}
}
