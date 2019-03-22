package com.cognizant.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.entity.Product;
import com.cognizant.entity.User;
import com.cognizant.entity.Vendor;
import com.cognizant.service.ProductService;
import com.cognizant.service.UserService;
import com.cognizant.service.VendorService;

@Controller
public class AdminController {
	
	
	@Autowired
	private UserService userservice;
	@Autowired
	private ProductService productService;
    @Autowired
    private VendorService vendorService;
    @Autowired
    private Validator validator;
    
	
	@RequestMapping(value="doLogin.htm",method=RequestMethod.GET)
	public ModelAndView doLogin(@RequestParam("uname") String Username,@RequestParam("pname") String Password )
	{
		boolean userLogin=userservice.checkUser(Username,Password);
		ModelAndView mv=new ModelAndView();
		System.out.println("--User Controller--");
		if(userLogin==true) {
			List<Product> productList=productService.getAllProducts();
	    	mv.addObject("productList",productList);
	    	mv.setViewName("viewproducts");
		}
		else if(userLogin==false){
			Vendor vendorLogin=vendorService.checkVendor(Username, Password);
			String vendorid=vendorLogin.getVendorID();
			System.out.println("*************vendor id:"+vendorid);
			if(vendorid!= null){
				List<Product> productList=productService.getAllProducts();
		    	mv.addObject("productList",productList);
		    	
			mv.setViewName("vendorproducts");
			}
			else{
				mv.setViewName("login");
			}
		}
			else {
			mv.setViewName("login");	
		}
		return mv;
	}
	
	@ModelAttribute("user")
	public User createCommandObject(){
		User user=new User();		
		return user;
	}
	
	@RequestMapping(value="index.htm",method=RequestMethod.GET)
	public String loadForm(){
		
		return "login";
	}
	

    @RequestMapping(value="productform.htm",method=RequestMethod.GET)
    public String loadProductForm(){
    	return "productform";
    }
    
    @RequestMapping(value="addproduct.htm",method=RequestMethod.POST)
    public ModelAndView persistProduct(@ModelAttribute("product")Product product,Errors errors)
    {    	
    	ModelAndView mv=new ModelAndView();
    	
    	ValidationUtils.invokeValidator(validator, product, errors);
    	if(errors.hasErrors())
    	{
    		mv.setViewName("productform");
    	}
    	else
    	{
		boolean productPersist=productService.persistsProduct(product);
		
		if(productPersist){
			mv.addObject("status", "Product sucessfully registered");
			List<Product> productList=productService.getAllProducts();
	    	mv.addObject("productList",productList);
	    	mv.setViewName("viewproducts");
	    	return mv;	
		}
		else
		{
			mv.addObject("status","Product registration failed");
		}
		mv.setViewName("productform");
    	}
    	return mv;
    }
    
    
    @ModelAttribute("product")
    public Product createProductObject(){
    	Product product=new Product();
    	product.setProductId(0);
    	product.setProductName("Please type product name");
    	product.setProductDescription("Please desrcribe product");
    	product.setProductPrice(0.0);
    	return product;
    }
	
    
    @ModelAttribute("categoryList")
	public List<String> createProductCategory(){
			return productService.getProductCategoryNames();
		}
	
    @RequestMapping(value="logoutUser.htm",method=RequestMethod.GET )
    public ModelAndView logoutUser(HttpSession httpSession){
    	ModelAndView mv=new ModelAndView();
    	httpSession.invalidate();
    	mv.setViewName("login");
    	return mv;	
    }
    @RequestMapping(value="delete.htm",method=RequestMethod.GET)
    public ModelAndView delete(@RequestParam("productId") String productId){
    	
		int productid=Integer.parseInt(productId);
		boolean res=productService.deleteproduct(productid);
    	ModelAndView mv=new ModelAndView();
    	List<Product> productList=productService.getAllProducts();
    	mv.addObject("productList",productList);
    	mv.setViewName("viewproducts");
    	return mv;	
    }
    
    @RequestMapping(value="deleteProduct.htm",method=RequestMethod.GET )
    public ModelAndView deleteProduct(@RequestParam("productId") String productId){
    	
		int productid=Integer.parseInt(productId);
		boolean res=productService.deleteproduct(productid);
    	ModelAndView mv=new ModelAndView();
    	List<Product> productList=productService.getAllProducts();
    	mv.addObject("productList",productList);
    	mv.setViewName("viewproducts");
    	return mv;	
    }
    
    @RequestMapping(value="addQuantity.htm",method=RequestMethod.GET)
    public ModelAndView addQuantity(@RequestParam("product_Id") String Product_Id,@RequestParam("quantity") String Quantity){
    	ModelAndView mv=new ModelAndView();
    	List<Product> productList=productService.getAllProducts();
    	mv.addObject("productList",productList);
    	mv.setViewName("vendorproducts");
    	return mv;
    }
   
	
}
