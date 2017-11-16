package examples.ch2;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.math.BigInteger;

public class CachedFactorizer implements Servlet {

    private BigInteger lastNumber;
    private BigInteger[] lastFactors;

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        BigInteger i = extractFromRequest(servletRequest);

        synchronized (this) {
            if (i.equals(lastNumber)) {
                encodeIntoResponse(servletResponse, lastFactors);
                return;
            }
        }

        BigInteger[] factors = factor(i);
        synchronized (this) {
            lastNumber = i;
            encodeIntoResponse(servletResponse, factors);
        }
    }

}
