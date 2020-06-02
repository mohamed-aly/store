package com.vis.store.rest;


import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stationary.store.model.*;
import stationary.store.service.category.CategoryService;
import stationary.store.service.offer.OfferService;
import stationary.store.service.orderItem.OrderItemService;
import stationary.store.service.product.ProductService;
import stationary.store.service.user.UserService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@CrossOrigin
@RequestMapping("/api")
public class AppRestController {

    // autowire the UserService
    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private OfferService offerService;

    @Autowired
    private OrderItemService orderItemService;


    @GetMapping("/product/bestseller")
    @ResponseBody
    public ResponseEntity<Object> getBestSellers(@RequestParam(required = false) Integer limit) {

        List<Product> products = orderItemService.getBestSellers(limit);

        List<Map<String, Object>> entities = new ArrayList<>();
        for (Product p : products) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("productId", p.getProductId());
            map.put("productName", p.getProductName());
            map.put("description", p.getDescription());
            map.put("imageUrl", p.getImageUrl());
            map.put("minStock", p.getMinStock());
            map.put("price", p.getPatches().iterator().next().getSellPrice());
            map.put("discount", p.getOffers().iterator().next().getDiscount());

            entities.add(map);
        }
        return new ResponseEntity<Object>(entities, HttpStatus.OK);

//         }


    }

    @GetMapping("/product")
    public List<Product> getProducts() {

        return productService.getProducts();
    }

    @GetMapping("/category")
    public List<Category> getCategoriesWithLimit(@RequestParam(required = false) Integer limit) {

        List<Category> categories = categoryService.getCategories(limit);

        return categories;
    }


    // add mapping for GET /users
    @GetMapping("/users")
    public List<User> getUsers() {

        return userService.getUsers();

    }

    @GetMapping("/offer")
    public List<Offer> getOffers() {

        return offerService.getOffers();

    }




}
	

	

















