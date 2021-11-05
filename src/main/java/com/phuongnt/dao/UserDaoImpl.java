package com.phuongnt.dao;

import com.phuongnt.entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    public Serializable create(User user) {
        Session session = null;
        Transaction transaction = null;
        Serializable id = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            id = session.save(user);

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return id;
    }

    public User read(Serializable id) {
        Session session = null;
        Transaction transaction = null;
        User readEntity = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            readEntity = (User) session.get(User.class, id);

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return readEntity;
    }
}
