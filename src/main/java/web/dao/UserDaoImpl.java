package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public List<User> listUsers() {
        List userList = entityManager.createQuery("from User").getResultList();
        return userList;
    }

    @Override
    public void changeUser(User user) {
        entityManager.merge(user);
//        entityManager.createQuery("update User u set u.firstName = :fn, u.lastName= :ln, u.email = :em where u.id = :id")
//                .setParameter("fn",user.getFirstName())
//                .setParameter("ln",user.getLastName())
//                .setParameter("em",user.getEmail())
//                .setParameter("id",user.getId())
//                .executeUpdate();
    }

    @Override
    public void removeUser(Long id) {
        entityManager.createQuery("Delete from User u where u.id = :id").setParameter("id", id).executeUpdate();
    }

    @Override
    public User findById(Long id) {
//        User user = (User) entityManager.createQuery("FROM User u where u.id = :id").setParameter("id",id).getSingleResult();
//        return user;
        return entityManager.find(User.class, id);
    }
}
