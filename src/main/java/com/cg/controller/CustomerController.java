package com.cg.controller;

import com.cg.exception.DataInputException;
import com.cg.model.Product;
import com.cg.model.Role;
import com.cg.model.User;
import com.cg.model.dto.product.ProductDTO;
import com.cg.service.product.IProductService;
import com.cg.service.user.IUserService;
import com.cg.utils.AppUtils;
import com.cg.utils.ValidateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/shop")
public class CustomerController {

    @Autowired
    private AppUtils appUtils;

    @Autowired
    private IUserService userService;
    @Autowired
    private ValidateUtils validateUtils;
    @Autowired
    private IProductService productService;

    @GetMapping
    public String showPageHome(Model model) {
        String username = appUtils.getPrincipalUsername();

        Optional<User> userOptional = userService.findByUsername(username);

        if (!userOptional.isPresent()) {
            throw new DataInputException("User not valid");
        }

        Role role = userOptional.get().getRole();
        String roleCode = role.getCode();

//        username = username.substring(0, username.indexOf("@"));
        model.addAttribute("username", username);
        model.addAttribute("roleCode", roleCode);
        return "shop/index";
    }

    @GetMapping("/product-detail/{id}")
    private String showProductDetail(@PathVariable String id ,Model model) {
        if (!validateUtils.isNumberValid(id)) {
            throw new DataInputException("Mã sản phẩm không hợp lệ");
        }
        Long productId = Long.parseLong(id);

        Optional<Product> product = productService.findById(productId);

        if (product.isEmpty()) {
            throw new DataInputException("Không tìm thấy sản phẩm");
        }
        model.addAttribute("product", product.get().toProductDTO());
        return "shop/product-detail";
    }

//    @GetMapping("/products")
//    public String showListProduct() {
//        return "dashboard/list-product";
//    }
//    @GetMapping("/customers")
//    public String showListCustomer() {
//        return "dashboard/list-customer";
//    }

}
