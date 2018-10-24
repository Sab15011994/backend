package com.niit.controller;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
@RequestMapping(value="/all/getallproducts")
public String getAllProducts(Model model)
{
	List products= (List) productService.getAllProducts();
	model.addAttribute("products",products);
	return "listofproducts";
	}
@RequestMapping(value="/all/getproduct")
public String getProduct(@RequestParam int id,Model model) {
	Product product=productService.getProduct(id);
	model.addAttribute("productAttr",product);
return "viewproduct";
}
//public string getAllProducts(Model model) {
//	List<Product> products=productService.getAllProducts();
//	model.addAttribute("products",products);
//return "listofproducts";
//}
//@RequestMapping(value="/all/getproduct")
//public String getProduct1(@RequestParam int id,Model model) {
//	Product product=productService.getProduct(id);
//	model.addAttribute("productAttr",product);
//return "view";
//}
//@RequestMapping(value="/admin/deleteproduct")
//public String deleteProduct(@RequestParam int id) {
//	productService.deleteProduct(id);
//	return "redirect:/all/getallproducts";
//}


}

