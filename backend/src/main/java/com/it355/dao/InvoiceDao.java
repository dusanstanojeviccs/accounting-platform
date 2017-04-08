package com.it355.dao;

import com.it355.models.Invoice;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class InvoiceDao extends HibernateDaoSupport {

    @Autowired
    public InvoiceDao(SessionFactory sessionFactory) {
        setSessionFactory(sessionFactory);
    }

    @Transactional
    public void delete(Invoice invoice) {
        invoice.setDeleted(true);
        getHibernateTemplate().update(invoice);
    }

    public Invoice findById(long id, long userId) {
        List list = getHibernateTemplate().find("from Invoice where id=? and userId=? and deleted=false", id, userId);
        return ((Invoice) list.get(0)).explode();
    }
    public List<Invoice> findAll(long userId) {
        return ((List<Invoice>)getHibernateTemplate().find("from Invoice where userId=? and deleted=false", userId)).stream().map(invoice -> invoice.explode()).collect(Collectors.toList());
    }

    @Transactional
    public Invoice update(Invoice invoice) {
        getHibernateTemplate().update(invoice.implode());
        return invoice;
    }

    @Transactional
    public Invoice insert(Invoice invoice) {
        getHibernateTemplate().save(invoice.implode());
        return invoice;
    }
}