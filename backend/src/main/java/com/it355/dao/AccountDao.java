package com.it355.dao;

import com.it355.models.Account;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AccountDao extends HibernateDaoSupport {

    @Autowired
    public AccountDao(SessionFactory sessionFactory) {
        setSessionFactory(sessionFactory);
    }

    @Transactional
    public void delete(Account account) {
        account.setDeleted(true);
        getHibernateTemplate().update(account);
    }

    public Account findById(long id, long userId) {
        List list = getHibernateTemplate().find("from Account where id=? and userId=? and deleted=false", id, userId);
        return (Account) list.get(0);
    }
    public List<Account> findAll(long userId) {
        return (List<Account>)getHibernateTemplate().find("from Account where userId=? and deleted=false", userId);
    }
    @Transactional
    public Account update(Account account) {
        getHibernateTemplate().update(account);
        return account;
    }
    @Transactional
    public Account insert(Account account) {
        getHibernateTemplate().save(account);
        return account;
    }
}