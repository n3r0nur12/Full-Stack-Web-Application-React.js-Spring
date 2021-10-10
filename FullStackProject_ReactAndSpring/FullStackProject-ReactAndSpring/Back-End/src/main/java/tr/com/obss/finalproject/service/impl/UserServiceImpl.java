package tr.com.obss.finalproject.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.com.obss.finalproject.dao.*;
import tr.com.obss.finalproject.model.*;
import tr.com.obss.finalproject.service.UserService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Slf4j
@Service
@Transactional
public class UserServiceImpl implements UserService {


    private ProductRepository productRepository;
    private UserRepository userRepository;
    private FavoriteListRepository favoriteListRepository;
    private BlackListRepository blackListRepository;
    private SellerRepository sellerRepository;
    @Autowired
    public UserServiceImpl(ProductRepository productRepository, UserRepository userRepository, FavoriteListRepository favoriteListRepository, BlackListRepository blackListRepository, SellerRepository sellerRepository) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
        this.favoriteListRepository = favoriteListRepository;
        this.blackListRepository = blackListRepository;
        this.sellerRepository = sellerRepository;
    }



    //
    @Override
    public void addProductToFavoriteList(Long userId, Long productId) {
        FavoriteList tempFavoriteList = favoriteListRepository.findFavoriteListByUserid(userId);
        Product tempProduct = productRepository.findProductById(productId);

        tempProduct.getFavorites().add(tempFavoriteList);
        tempFavoriteList.getProducts().add(tempProduct);

        productRepository.save(tempProduct);
    }

    //
    @Override
    public void removeProductFromFavoriteList(Long userId, Long productId) {
        FavoriteList tempFavoriteList = favoriteListRepository.findFavoriteListByUserid(userId);
        Product tempProduct = productRepository.findProductById(productId);

        tempProduct.getFavorites().remove(tempFavoriteList);
        tempFavoriteList.getProducts().remove(tempProduct);

        productRepository.save(tempProduct);
    }

    //
    @Override
    public void addSellerToBlackList(Long userId, Long sellerId) {
        BlackList tempBlackList = blackListRepository.findBlackListByUserid(userId);
        Seller tempSeller = sellerRepository.findSellerById(sellerId);

        tempSeller.getBlackList().add(tempBlackList);
        tempBlackList.getSellers().add(tempSeller);

        sellerRepository.save(tempSeller);
    }

    //
    @Override
    public void removeSellerFromBlackList(Long userId, Long sellerId) {
        BlackList tempBlackList = blackListRepository.findBlackListByUserid(userId);
        Seller tempSeller = sellerRepository.findSellerById(sellerId);

        tempSeller.getBlackList().remove(tempBlackList);
        tempBlackList.getSellers().remove(tempSeller);

        sellerRepository.save(tempSeller);
    }

    //
    @Override
    public Set<Product> getFavoriteList(Long userId) {
        return favoriteListRepository.findFavoriteListByUserid(userId).getProducts();
    }

    //
    @Override
    public Set<Seller> getBlackList(Long userId) {
        BlackList tempBlackList = blackListRepository.findBlackListByUserid(userId);
        return tempBlackList.getSellers();
    }

    //
    @Override
    public List<Product> searchProduct(String keyword) {
        return productRepository.findByNameContaining(keyword);
    }

    @Override
    public List<Seller> searchSeller(String keyword) {
        return sellerRepository.findByNameContaining("");
    }
}
