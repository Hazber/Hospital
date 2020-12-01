package controller;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Exit extends Command {
    public static final Logger logger = Logger.getLogger(Exit.class);
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        HttpSession session = req.getSession();
        logger.debug(session);
        session.invalidate();
        return "/authorization.jsp";
    }
}
