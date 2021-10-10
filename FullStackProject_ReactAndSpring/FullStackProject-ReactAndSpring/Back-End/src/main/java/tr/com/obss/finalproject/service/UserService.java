package tr.com.obss.finalproject.service;

import tr.com.obss.finalproject.model.Product;
import tr.com.obss.finalproject.model.Seller;

import java.util.List;
import java.util.Set;

public interface UserService {
    void addProductToFavoriteList(Long userId, Long productId);
    void removeProductFromFavoriteList(Long userId, Long productId);
    void addSellerToBlackList(Long userId, Long sellerId);
    void removeSellerFromBlackList(Long userId, Long sellerId);
    Set<Product> getFavoriteList(Long userId);
    Set<Seller> getBlackList(Long userId);
    List<Product> searchProduct(String keyword);
    List<Seller> searchSeller(String keyword);
}
