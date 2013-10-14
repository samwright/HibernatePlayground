package io.github.samwright.hibernate.testmodel;

import io.github.samwright.hibernate.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.assertEquals;

/**
 * User: Sam Wright Date: 14/10/2013 Time: 14:55
 */
public class SupplierTest {

    final Logger logger = LoggerFactory.getLogger(SupplierTest.class);

//    @Test
//    public void testInsert() throws Exception {
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        session.beginTransaction();
//        Object sID = null;
//        Transaction transaction = null;
//
//        Supplier supplier = new Supplier("S1", "SMITH", 20, "LONDON");
//
//        try {
//            transaction = session.beginTransaction();
//            sID = session.save(supplier);
//            transaction.commit();
//        } catch (HibernateException e) {
//            if (transaction != null)
//                transaction.rollback();
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//
//        System.out.println("returned ID: " + sID);
//        assertEquals("S1", supplier.getId());
//    }


    @Test
    public void testTestDataExists() throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            List suppliers = session.createQuery("FROM Supplier").list();
            assertFalse(suppliers.isEmpty());
            logger.info("Loaded suppliers: " + suppliers);
        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Test
    public void testQuery() throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            List suppliers = session.createQuery("FROM Supplier WHERE status = 10").list();
            assertEquals(1, suppliers.size());

            Supplier supplier = (Supplier) suppliers.get(0);
            assertEquals("S2", supplier.getId());
            assertEquals("JONES", supplier.getName());
            assertEquals(10, supplier.getStatus());
            assertEquals("PARIS", supplier.getCity());

        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

    }
}
