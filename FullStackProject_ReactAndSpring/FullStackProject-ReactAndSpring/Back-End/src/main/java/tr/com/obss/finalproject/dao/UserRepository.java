package tr.com.obss.finalproject.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tr.com.obss.finalproject.model.Product;
import tr.com.obss.finalproject.model.User;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface UserRepository extends CrudRepository<User,Long> {
    User findUserById(Long userId);

    User findUserByEmail(String email);

    List<User> findByNameContaining(String keyword);
}
