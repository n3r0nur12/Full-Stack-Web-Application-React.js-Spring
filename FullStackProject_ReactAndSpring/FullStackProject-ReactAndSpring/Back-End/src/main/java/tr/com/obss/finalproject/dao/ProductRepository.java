package tr.com.obss.finalproject.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tr.com.obss.finalproject.model.Product;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public interface ProductRepository extends CrudRepository<Product,Long> {
    Product findProductById(Long ProductId);

    List<Product> findByNameContaining(String keyword);
}
