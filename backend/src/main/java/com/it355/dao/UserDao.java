package com.it355.dao;

import com.it355.models.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public class UserDao extends HibernateDaoSupport {

    @Autowired
    public UserDao(SessionFactory sessionFactory) {
        setSessionFactory(sessionFactory);
    }
    @Transactional public void delete(User user) {
        getHibernateTemplate().delete(user);
    }

    public Optional<User> findByUsername(String username) {
        return ((List<User>)getHibernateTemplate().find("from User where username=?", username)).stream().findFirst();
    }

    public User findById(long id) {
        List list = getHibernateTemplate().find("from User where id=?", id);
        return (User) list.get(0);
    }
    public List<User> findAll() {
        return (List<User>)getHibernateTemplate().find("from User");
    }

    @Transactional
    public User update(User user) {
        getHibernateTemplate().update(user);
        return user;
    }
    @Transactional
    public User insert(User user) {
        getHibernateTemplate().save(user);
        return user;
    }
}