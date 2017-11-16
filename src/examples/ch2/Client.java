package examples.ch2;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

public class Client implements Runnable {

    private static AtomicLong counter = new AtomicLong(0L);

    private final long id;
    private final Servlet servlet;

    public Client(Servlet servlet) {
        this.servlet = servlet;
        this.id = counter.incrementAndGet();
    }

    @Override
    public void run() {
        try {
            System.out.println("client " + id + " request");
            servlet.service(null, null);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
