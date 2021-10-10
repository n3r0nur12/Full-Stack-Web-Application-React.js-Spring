package tr.com.obss.finalproject.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tr.com.obss.finalproject.model.Product;
import tr.com.obss.finalproject.model.Seller;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public interface SellerRepository extends CrudRepository<Seller,Long> {
    Seller findSellerById(Long id);
    Seller findSellerByName(String name);
    List<Seller> findByNameContaining(String keyword);
}
