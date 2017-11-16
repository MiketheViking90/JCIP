package examples.ch2;

import lombok.Getter;
import net.jcip.annotations.ThreadSafe;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.math.BigInteger;


@ThreadSafe
public class UnsafeCountingFactorizer implements Servlet {

    @Getter
    private long count = 0;

    @Override
    public void service(ServletRequest req, ServletResponse resp)
            throws ServletException, IOException {
        BigInteger i = extractFromRequest(req);
        BigInteger[] factors = factor(i);

        ++count;

        encodeIntoResponse(resp, factors);
    }

}
