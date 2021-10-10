package tr.com.obss.finalproject.service;

import tr.com.obss.finalproject.model.Product;
import tr.com.obss.finalproject.model.Seller;
import tr.com.obss.finalproject.model.User;

import java.util.List;

public interface AdminService {
    void deleteProduct(Long id);
    void updateProduct(Product product, Long id);
    void addProduct(Product product);
    void deleteUser(Long id);
    void updateUser(User user, Long id);
    void addUser(User user);
    void deleteSeller(Long id);
    void updateSeller(Seller seller, Long id);
    void addSeller(Seller seller);
    Product getProduct(Long id);
    User getUser(Long id);
    Seller getSeller(Long id);
    List<Product> searchProduct(String keyword);
    List<Seller> searchSeller(String keyword);
    List<User> searchUser(String keyword);
}
