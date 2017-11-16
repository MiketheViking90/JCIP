package examples.ch2;

import net.jcip.annotations.ThreadSafe;

import javax.servlet.*;
import java.io.IOException;
import java.math.BigInteger;


@ThreadSafe
public class StatelessFactorizer implements Servlet {

    @Override
    public void service(ServletRequest req, ServletResponse resp)
            throws ServletException, IOException {
        BigInteger i = extractFromRequest(req);
        BigInteger[] factors = factor(i);
        encodeIntoResponse(resp, factors);
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {}

    @Override
    public ServletConfig getServletConfig() { return null; }

    @Override
    public String getServletInfo() { return null; }

    @Override
    public void destroy() {}
}
