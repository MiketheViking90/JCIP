package examples.ch2;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.math.BigInteger;

public interface Servlet extends javax.servlet.Servlet {

    @Override
    default void init(ServletConfig servletConfig) throws ServletException {}

    @Override
    default ServletConfig getServletConfig() { return null; }

    @Override
    default String getServletInfo() { return null; }

    @Override
    default void destroy() {}

    default BigInteger extractFromRequest(ServletRequest req) {
        return BigInteger.valueOf(10L);
    }

    default BigInteger[] factor(BigInteger input) {

        BigInteger[] ret = new BigInteger[2];

        ret[0] = BigInteger.valueOf(2L);
        ret[1] = BigInteger.valueOf(5L);

        return ret;
    }

    default void encodeIntoResponse(ServletResponse res, BigInteger[] factors) {
    }
}
