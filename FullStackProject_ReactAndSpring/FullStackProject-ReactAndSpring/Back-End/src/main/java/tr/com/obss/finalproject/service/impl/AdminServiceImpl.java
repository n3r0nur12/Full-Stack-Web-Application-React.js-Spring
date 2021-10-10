package tr.com.obss.finalproject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.com.obss.finalproject.dao.*;
import tr.com.obss.finalproject.model.*;
import tr.com.obss.finalproject.service.AdminService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    private ProductRepository productRepository;
    private UserRepository userRepository;
    private SellerRepository sellerRepository;
    private FavoriteListRepository favoriteListRepository;
    private BlackListRepository blackListRepository;
    @Autowired
    public AdminServiceImpl(ProductRepository productRepository, UserRepository userRepository, SellerRepository sellerRepository, FavoriteListRepository favoriteListRepository, BlackListRepository blackListRepository) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
        this.sellerRepository = sellerRepository;
        this.favoriteListRepository = favoriteListRepository;
        this.blackListRepository = blackListRepository;
    }

    //
    @Override
    public void deleteProduct(Long id) {
        Product product = productRepository.findProductById(id);
        productRepository.delete(product);
    }

    //
    @Override
    public void updateProduct(Product product, Long id) {
        Product tempProduct = productRepository.findProductById(id);
        tempProduct.setPrice(product.getPrice());
        tempProduct.setName(product.getName());
        productRepository.save(tempProduct);
    }

    //
    @Override
    public void addProduct(Product product) {
        productRepository.save(product);
    }

    //
    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findUserById(id);
        userRepository.delete(user);
    }

    //
    @Override
    public void updateUser(User user, Long id) {
        User tempUser = userRepository.findUserById(id);
        tempUser.setName(user.getName());
        tempUser.setAddress(user.getAddress());
        tempUser.setEmail(user.getEmail());
        tempUser.setPassword(user.getPassword());
        tempUser.setSurname(user.getSurname());
        userRepository.save(tempUser);
    }

    //
    @Override
    public void addUser(User user) {

        FavoriteList favoriteList = new FavoriteList(user);
        BlackList blackList = new BlackList(user);

        user.setBlackList(blackList);
        user.setFavoriteList(favoriteList);

        userRepository.save(user);

        favoriteList.setUserid(userRepository.findUserByEmail(user.getEmail()).getId());
        blackList.setUserid(userRepository.findUserByEmail(user.getEmail()).getId());

        blackListRepository.save(blackList);
        favoriteListRepository.save(favoriteList);
    }

    //
    @Override
    public void addSeller(Seller seller){
        sellerRepository.save(seller);
    }

    @Override
    public Product getProduct(Long id) {
        return productRepository.findProductById(id);
    }

    @Override
    public User getUser(Long id) {
        return userRepository.findUserById(id);
    }

    @Override
    public Seller getSeller(Long id) {
        return sellerRepository.findSellerById(id);
    }

    //
    @Override
    public void deleteSeller(Long id) {
        Seller seller = sellerRepository.findSellerById(id);
        sellerRepository.delete(seller);
    }

    //
    @Override
    public void updateSeller(Seller seller, Long id) {
        Seller tempSeller = sellerRepository.findSellerById(id);
        tempSeller.setAddress(seller.getAddress());
        tempSeller.setName(seller.getName());
        sellerRepository.save(tempSeller);
    }

    //
    @Override
    public List<Product> searchProduct(String keyword) {return productRepository.findByNameContaining(keyword);}

    //
    @Override
    public List<Seller> searchSeller(String keyword) {
        return sellerRepository.findByNameContaining(keyword);
    }

    //
    @Override
    public List<User> searchUser(String keyword) {
        return userRepository.findByNameContaining(keyword);
    }
}
