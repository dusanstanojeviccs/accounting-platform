package com.it355.dao;

import com.it355.models.Vendor;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class VendorDao extends HibernateDaoSupport {

    @Autowired
    public VendorDao(SessionFactory sessionFactory) {
        setSessionFactory(sessionFactory);
    }

    @Transactional
    public void delete(Vendor vendor) {
        vendor.setDeleted(true);
        getHibernateTemplate().update(vendor);
    }

    public Vendor findById(long id, long userId) {
        List list = getHibernateTemplate().find("from Vendor where id=? and userId=? and deleted=false", id, userId);
        return (Vendor) list.get(0);
    }
    public List<Vendor> findAll(long userId) {
        return (List<Vendor>)getHibernateTemplate().find("from Vendor where userId=? and deleted=false", userId);
    }
    @Transactional
    public Vendor update(Vendor vendor) {
        getHibernateTemplate().update(vendor);
        return vendor;
    }
    @Transactional
    public Vendor insert(Vendor vendor) {
        getHibernateTemplate().save(vendor);
        return vendor;
    }
}