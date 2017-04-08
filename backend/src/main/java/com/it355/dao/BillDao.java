package com.it355.dao;

import com.it355.models.Bill;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BillDao extends HibernateDaoSupport {

    @Autowired
    public BillDao(SessionFactory sessionFactory) {
        setSessionFactory(sessionFactory);
    }

    @Transactional
    public void delete(Bill bill) {
        bill.setDeleted(true);
        getHibernateTemplate().update(bill);
    }

    public Bill findById(long id, long userId) {
        List list = getHibernateTemplate().find("from Bill where id=? and userId=? and deleted=false", id, userId);
        return ((Bill) list.get(0)).explode();
    }
    public List<Bill> findAll(long userId) {
        return ((List<Bill>)getHibernateTemplate().find("from Bill where userId=? and deleted=false", userId)).stream().map(bill -> bill.explode()).collect(Collectors.toList());
    }

    @Transactional
    public Bill update(Bill bill) {
        getHibernateTemplate().update(bill.implode());
        return bill;
    }
    @Transactional
    public Bill insert(Bill bill) {
        getHibernateTemplate().save(bill.implode());
        return bill;
    }
}