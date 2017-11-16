package examples.ch2;

import org.testng.annotations.Test;

public class UnsafeCachingFactorizerTest {

    @Test
    public void testService() {
        UnsafeCachingFactorizer ucf = new UnsafeCachingFactorizer();
        Client c1 = new Client(ucf);
        Client c2 = new Client(ucf);
        Client c3 = new Client(ucf);
        Client c4 = new Client(ucf);

        Thread t1 = new Thread(c1);
        Thread t2 = new Thread(c2);
        Thread t3 = new Thread(c3);
        Thread t4 = new Thread(c4);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}