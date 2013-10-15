package io.github.samwright.hibernate.testmodel;

import io.github.samwright.hibernate.HibernateUtil;
import io.github.samwright.hibernate.Transactor;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.junit.Test;

import org.hibernate.Transaction;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

/**
 * User: Sam Wright Date: 15/10/2013 Time: 11:34
 */
public class SupplyTest {
    @Test
    public void testGetSupplier() throws Exception {
        String firstSupplierID = new Transactor<String>() {
            @Override
            public String transact(Session session) {
                return getFirstSupply(session).getSupplier().getId();
            }
        }.run();

        assertEquals("S1", firstSupplierID);
    }

    public Supply getFirstSupply(Session session) {
        return (Supply) session.createQuery("from Supply where quantity = 200").iterate().next();
    }

    @Test
    public void testGetFirstSupply() throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            session.beginTransaction();
            assertEquals(200, getFirstSupply(session).getQuantity());
        } finally {
            session.close();
        }
    }
}
