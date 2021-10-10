package tr.com.obss.finalproject.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tr.com.obss.finalproject.model.BlackList;
import tr.com.obss.finalproject.model.FavoriteList;
import tr.com.obss.finalproject.model.User;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface BlackListRepository extends CrudRepository<BlackList,Long> {
    BlackList findBlackListByUser(User user);
    BlackList findBlackListByUserid(Long userid);
    List<BlackList> findAll();
}
