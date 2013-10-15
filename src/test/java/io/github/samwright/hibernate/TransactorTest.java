package io.github.samwright.hibernate;

import io.github.samwright.hibernate.testmodel.Supply;
import org.hibernate.Session;
import org.junit.Test;

/**
 * User: Sam Wright Date: 15/10/2013 Time: 12:32
 */
public class TransactorTest {
    @Test
    public void testRun() throws Exception {
        Supply supply = new Transactor<Supply>() {
            @Override
            public Supply transact(Session session) {
                return (Supply) session.createQuery("from Supply where quantity = 200").iterate().next();
            }
        }.run();

    }
}
