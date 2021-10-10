package tr.com.obss.finalproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tr.com.obss.finalproject.dto.ProductDto;
import tr.com.obss.finalproject.dto.SellerDto;
import tr.com.obss.finalproject.model.Product;
import tr.com.obss.finalproject.model.Seller;
import tr.com.obss.finalproject.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


/*
 * Author: ONURCAN ISLER
 * Date: 19.08.2021
 * Organization: OBSS - Java Summer School
 * Title: OBSS - Java Summer School Term Project - Online Shopping List Editor
 */

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    private UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }



    @GetMapping("/{userid}/products")
    @ResponseBody
    List<ProductDto> searchProduct(@PathVariable Long userid){

        List<Product> allProducts = userService.searchProduct("");
        Set<Product> userProducts = userService.getFavoriteList(userid);

        List<ProductDto> ret = new ArrayList<ProductDto>();

        for(Product product:allProducts){
            if(!userProducts.contains(product)) {
                ret.add(ProductDto.convertToDtoObject(product));
            }
        }
        return ret;
    }

    @GetMapping("/{userid}/sellers")
    @ResponseBody
    List<SellerDto> searchSeller(@PathVariable Long userid){

        List<Seller> allSellers = userService.searchSeller("");
        Set<Seller> userSellers = userService.getBlackList(userid);

        List<SellerDto> ret = new ArrayList<SellerDto>();

        for(Seller seller:allSellers){
            if(!userSellers.contains(seller)) {
                ret.add(SellerDto.convertToDtoObject(seller));
            }
        }
        return ret;
    }



    @GetMapping("/{userid}/blacklist")
    @ResponseBody
    List<SellerDto> getBlackList(@PathVariable Long userid){
        Set<Seller> sellerSet = userService.getBlackList(userid);

        List<SellerDto> ret = new ArrayList<SellerDto>();
        for(Seller seller:sellerSet){
            ret.add(SellerDto.convertToDtoObject(seller));
        }
        return ret;
    }

    @GetMapping("/{userid}/favorites")
    @ResponseBody
    List<ProductDto> getFavoriteList(@PathVariable Long userid){
        Set<Product> productSet = userService.getFavoriteList(userid);

        List<ProductDto> ret = new ArrayList<ProductDto>();
        for(Product product:productSet){
            ret.add(ProductDto.convertToDtoObject(product));
        }
        return ret;
    }



    @DeleteMapping("/{userid}/blacklist/{sellerid}")
    @ResponseBody
    public String removeSellerFromBlackList(@PathVariable("sellerid") Long sellerId,@PathVariable("userid") Long userid){
        userService.removeSellerFromBlackList(userid,sellerId);
        return "Successfully removed the seller from the blacklist...";
    }

    @PostMapping("/{userid}/blacklist")
    @ResponseBody
    public String addSellerToBlackList(@RequestBody Long sellerId,@PathVariable Long userid){
        userService.addSellerToBlackList(userid,sellerId);
        return "Successfully added the seller to the blacklist...";
    }



    @DeleteMapping("/{userid}/favorites/{productid}")
    @ResponseBody
    public String removeProductFromFavoriteList(@PathVariable("userid") Long userid, @PathVariable("productid") Long productid){
        userService.removeProductFromFavoriteList(userid,productid);
        return "Successfully removed the product from the favorite list...";
    }

    @PostMapping("/{userid}/favorites")
    @ResponseBody
    public String addProductToFavoriteList(@RequestBody Long productid,@PathVariable Long userid){
        userService.addProductToFavoriteList(userid,productid);
        return "Successfully added the product to the favorite list...";
    }
}
