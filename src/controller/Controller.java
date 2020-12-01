package controller;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import model.StaffInfoEntity;

public class Controller extends HttpServlet {
	  RequestHelper requestHelper = RequestHelper.getInstance();
	    HttpSession session;
	    public Controller() {
	        super();
	    }

	    @Override
	    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	            throws ServletException, IOException {
	        session = req.getSession();
	        processRequest(req, resp);
	    }

	    @Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	            throws ServletException, IOException {
	        session = req.getSession();

	        processRequest(req, resp);
	    }

	    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	        String page;

	        Command command = requestHelper.getCommand(req);
	        logger.debug(command);
	        try {
	            page = command.execute(req, resp);
	        } catch (NeedlessTreatmentException e) {
	            logger.error(e.getMessage());
	            StaffInfoEntity staffInfo = (StaffInfoEntity) req.getSession().getAttribute("staff_info");
	            if (staffInfo.getTypeStaff().equals("Doctor")){
	                page =  "/view/doctorMainPage.jsp";
	            } else {
	                page =  "/view/nurseMainPage.jsp";
	            }
	        }

	        RequestDispatcher dispatcher = getServletContext().
	                getRequestDispatcher(page);
	        dispatcher.forward(req, resp);
	    }
}
