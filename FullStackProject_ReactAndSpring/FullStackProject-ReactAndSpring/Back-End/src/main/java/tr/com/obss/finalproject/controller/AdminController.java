package tr.com.obss.finalproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tr.com.obss.finalproject.dto.ProductDto;
import tr.com.obss.finalproject.dto.SellerDto;
import tr.com.obss.finalproject.dto.UserDto;
import tr.com.obss.finalproject.model.Product;
import tr.com.obss.finalproject.model.Seller;
import tr.com.obss.finalproject.model.User;
import tr.com.obss.finalproject.service.AdminService;

import java.util.ArrayList;
import java.util.List;

/*
 * Author: ONURCAN ISLER
 * Date: 19.08.2021
 * Organization: OBSS - Java Summer School
 * Title: OBSS - Java Summer School Term Project - Online Shopping List Editor
 */

@RequiredArgsConstructor
@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:3000")
public class AdminController {

    private AdminService adminService;
    @Autowired
    public AdminController(AdminService adminService){
        this.adminService = adminService;
    }

    @GetMapping("/products/{productid}")
    @ResponseBody
    public ProductDto getProduct(@PathVariable Long productid){
        return ProductDto.convertToDtoObject(adminService.getProduct(productid));
    }

    @GetMapping("/sellers/{sellerid}")
    @ResponseBody
    public SellerDto getSeller(@PathVariable Long sellerid){
        return SellerDto.convertToDtoObject(adminService.getSeller(sellerid));
    }

    @GetMapping("/users/{userid}")
    @ResponseBody
    public UserDto getUser(@PathVariable Long userid){
        return UserDto.convertToDtoObject(adminService.getUser(userid));
    }

    @GetMapping("/sellers")
    @ResponseBody
    public List<SellerDto> searchSeller(){
        List<Seller> tempArr = adminService.searchSeller("");
        List<SellerDto> ret = new ArrayList<SellerDto>();
        for(Seller seller:tempArr){
            ret.add(SellerDto.convertToDtoObject(seller));
        }
        return ret;
    }

    @PutMapping("/sellers/{sellerid}")
    @ResponseBody
    public String updateSeller(@RequestBody SellerDto dtoSeller,@PathVariable String sellerid){
        adminService.updateSeller(dtoSeller.convertToRealObject(),Long.valueOf(sellerid));
        return "Successfully updated the seller...";
    }

    @DeleteMapping("/sellers/{sellerid}")
    @ResponseBody
    public String deleteSeller(@PathVariable String sellerid){
        adminService.deleteSeller(Long.valueOf(sellerid));
        return "Successfully deleted the seller...";
    }

    @PostMapping("/sellers")
    @ResponseBody
    public String addSeller(@RequestBody SellerDto dtoSeller){
        adminService.addSeller(dtoSeller.convertToRealObject());
        return "Successfully added the seller...";
    }


    @PostMapping("/users")
    @ResponseBody
    public String addUser(@RequestBody UserDto dtoUser){
        adminService.addUser(dtoUser.convertToRealObject());
        return "Successfully added the user...";
    }

    @PutMapping("/users/{userid}")
    @ResponseBody
    public String updateUser(@RequestBody UserDto dtoUser, @PathVariable String userid){
        adminService.updateUser(dtoUser.convertToRealObject(),Long.valueOf(userid));
        return "Successfully updated the user...";
    }

    @DeleteMapping("/users/{userid}")
    @ResponseBody
    public String deleteUser(@PathVariable Long userid){
        adminService.deleteUser(userid);
        return "Successfully deleted the user...";
    }

    @GetMapping("/users")
    @ResponseBody
    public List<UserDto> searchUser(){
        List<User> tempArr = adminService.searchUser("");
        List<UserDto> ret = new ArrayList<UserDto>();
        for(User user:tempArr){
            ret.add(UserDto.convertToDtoObject(user));
        }
        return ret;
    }


    @DeleteMapping("/products/{productid}")
    @ResponseBody
    public String deleteProduct(@PathVariable Long productid){
        adminService.deleteProduct(productid);
        return "Successfully deleted the product...";
    }

    @PostMapping("/products")
    @ResponseBody
    public String addProduct(@RequestBody ProductDto dtoProduct){
        adminService.addProduct(dtoProduct.convertToRealObject());
        return "Successfully added the product...";
    }

    @PutMapping("/products/{productid}")
    @ResponseBody
    public String updateProduct(@RequestBody ProductDto dtoProduct,@PathVariable Long productid){
        adminService.updateProduct(dtoProduct.convertToRealObject(), productid);
        return "Successfully updated the product...";
    }

    @GetMapping("/products")
    @ResponseBody
    public List<ProductDto> searchProduct(){
        List<Product> tempArr = adminService.searchProduct("");
        List<ProductDto> ret = new ArrayList<ProductDto>();
        for(Product product:tempArr){
            ret.add(ProductDto.convertToDtoObject(product));
        }
        return ret;
    }
}
