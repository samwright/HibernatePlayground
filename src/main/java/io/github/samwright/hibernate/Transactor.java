package io.github.samwright.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 * Replaces boilerplate Hibernate code with an anonymous class (inspired by:
 * http://salilstock.blogspot.co.uk/2013/01/eliminating-hibernate-boiler-plate-code.html)
 */
public abstract class Transactor<T> {

    public abstract T transact(Session session);

    public T run() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            session.beginTransaction();
            T retval = transact(session);
            session.getTransaction().commit();
            return retval;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }

}
