package com.online_shop.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.online_shop.DTO.OrderDTO;
import com.online_shop.model.Customer;
import com.online_shop.model.Order;
import com.online_shop.model.Product;
import com.online_shop.service.CustomerService;
import com.online_shop.service.OrderService;
import com.online_shop.service.ProductService;

@Controller
public class MainController {

	@Autowired
	ProductService productService;

	@Autowired
	CustomerService customerService;

	@Autowired
	OrderService orderService;

	List<Product> selections = null;

	@GetMapping("/demoHome")
	public String getHomePage(Model model) {
		String message = "The Digital Shop";
		model.addAttribute("msg", message);
		if (list != null) {
			list.clear();

		}
		return "index";
	}

	@GetMapping("/products")
	public String getAllUsers(Model model) {
		List<Product> allProducts = productService.getAllProducts();
		System.out.println(allProducts);
		model.addAttribute("allProducts", allProducts);
		return "allproducts";
	}

	@GetMapping("/allUsers")
	public String getAllProducts(Model model) {
		List<Customer> allCustomers = customerService.getAllCustomers();
		System.out.println(allCustomers);
		model.addAttribute("allCustomers", allCustomers);
		return "customers";
	}

	@GetMapping("/getBarcode")
	public String getProductsPage(@ModelAttribute("orderDetails") OrderDTO orderDTO, Model model,
			HttpServletRequest req) {
		String message = req.getParameter("error");
		model.addAttribute("error", message);
		return "products";
	}

	@GetMapping("/findBarcode")
	public String matchBarcode(@ModelAttribute("orderDetails") OrderDTO orderDTO, Model model,
			HttpServletRequest request) {
		String message = "";
		Boolean isFoundRepeatedItem = false;
		String barcode = request.getParameter("barcode");
		Product oneProduct = productService.fetchProduct(barcode);

		if (selections == null)
			selections = new ArrayList<Product>();

		if (oneProduct == null) {
			message = "Invalid Barcode.Product not found";
		} else {
			oneProduct.setQuantity(oneProduct.getQuantity() + 1);
			double basePrice = oneProduct.getProductPrice();

			System.out.println(" Checking for repeatations");
			for (int i = 0; i < selections.size(); i++) {
				if (selections.get(i).getProductId() == oneProduct.getProductId()) {
					System.out.println("Index Matched !");
					int getQuatity = selections.get(i).getQuantity() + 1;
					double finalAmount = (basePrice * getQuatity);
					System.out.println("Quantity -" + getQuatity + "| Price -" + basePrice + "| Amount" + finalAmount);
					selections.get(i).setQuantity(getQuatity);
					selections.get(i).setProductPrice(finalAmount);

					isFoundRepeatedItem = true;
					break;
				}
			}
			if (!isFoundRepeatedItem)
				selections.add(oneProduct);

		}
		model.addAttribute("productList", selections);
		model.addAttribute("message", message);

		return "products";
	}

	@GetMapping("/generateOrder")
	public String generateOrders(@ModelAttribute("orderDetails") OrderDTO orderDTO, Model model) {
		List<String> output = productService.generateOrder(selections);
		String amount = output.get(output.size() - 1);
		double totalAmount = Double.parseDouble(amount);
		String productInfo = output.subList(0, output.size() - 1).toString();
		model.addAttribute("totalAmount", totalAmount);
		model.addAttribute("productInfo", productInfo);
		return "products";
	}

	@PostMapping("/takeOrder")
	public String makeOrders(@ModelAttribute("orderDetails") OrderDTO orderDTO, Model model) {
		String message = "";
		List<Order> lastOrder = null;
		Customer customer = customerService.getCustomerById(orderDTO.getCustomerId());
		System.out.println(customer);
		if (customer == null || customer.equals(null)) {
			model.addAttribute("error", "Invalid customer ! Please enter a valid customer ID.");
			return "redirect:/getBarcode";
		} else {
			Order saveOrder = orderService.makeOrder(orderDTO, customer);
			if (saveOrder == null) {
				message = "Something went wrong. Order failed !";
			} else {
				message = "You have successfully placed an order.";
			}
			List<Order> customerOrder = orderService.getOneOrder(customer);
			lastOrder = customerOrder.subList(customerOrder.size() - 1, customerOrder.size());
		}
		selections.clear();
		model.addAttribute("message", message);
		model.addAttribute("orders", lastOrder);
		return "success";
	}

	ArrayList<String> list = null;

	@RequestMapping(value = { "/newPage", "/hierarchy" }, method = RequestMethod.GET)
	public String getNewPage(Model model, HttpServletRequest req) {
		String country = req.getParameter("country");
		String state = req.getParameter("state");
		String city = req.getParameter("city");
		if (list == null) {
			list = new ArrayList<String>();
		}
		list.add(country);
		list.add(state);
		list.add(city);
		model.addAttribute("list", list);
		return "newPage";
	}

}
