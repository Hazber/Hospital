package controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;


public class SetLanguage extends Command {
    
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res)   {
        String language = req.getParameter("lang");
       
        if (language.equals("Ukrainian") || language.equals("Українська")) {
            req.getSession().setAttribute("language", new Locale("uk", "UA"));
       
        }
        if (language.equals("English") || language.equals("Англійська")) {
            req.getSession().setAttribute("language", new Locale("en", "US"));
           
        }
        
        return "/authorization.jsp";
    }
}
