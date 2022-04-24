package by.matrosov.interview.spring;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * будет ли создана новая транзакция
 * при вызове method2 из method1
 */
public class TransactionalProxy {

    @Transactional
    public void method1() {
        method2();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void method2() {

    }
}
