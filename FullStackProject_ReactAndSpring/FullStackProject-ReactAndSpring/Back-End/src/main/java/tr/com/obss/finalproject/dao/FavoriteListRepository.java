package tr.com.obss.finalproject.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tr.com.obss.finalproject.model.FavoriteList;
import tr.com.obss.finalproject.model.Product;
import tr.com.obss.finalproject.model.User;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface FavoriteListRepository extends CrudRepository<FavoriteList,Long> {
    FavoriteList findFavoriteListByUser(User user);

    FavoriteList findFavoriteListByUserid(Long userid);

    List<FavoriteList> findAll();
}
