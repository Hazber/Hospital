package controller;


import dao.IPatientInfoDAO;
import dao.IStaffDAO;
import model.PatientInfoEntity;
import model.StaffInfoEntity;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Authorization extends Command {
 
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {

        String email = req.getParameter("eMail");
        String password = req.getParameter("password");
        IPatientInfoDAO patientDao = factoryDAO.getPatientInfoDAO();
        IStaffDAO staffDao = factoryDAO.getStaffDAO();

        PatientInfoEntity patientInfo = patientDao.login(email, password);
        StaffInfoEntity staffInfo = staffDao.login(email, password);
        if (patientInfo != null) {
            PatientInfoLogic infoLogic = new PatientInfoLogic(factoryDAO, patientInfo);
            req.getSession().setAttribute("patient_info", infoLogic.getPatientInfo());
          
            return "/view/patientMainPage.jsp";
        } else if (staffInfo != null) {
            if (staffInfo.getTypeStaff().equals("Doctor")) {
                StaffLogic staffLogic = new StaffLogic(factoryDAO, staffInfo);
                req.getSession().setAttribute("staff_info", staffInfo);
                req.getSession().setAttribute("info_about_patient", staffLogic.getAllPatientsInfoForDoctor());
                
                return "/view/doctorMainPage.jsp";
            } else {
                StaffLogic staffLogic = new StaffLogic(factoryDAO, staffInfo);
                req.getSession().setAttribute("staff_info", staffInfo);
                req.getSession().setAttribute("info_about_patient", staffLogic.getPatientsInfoForNurse());
               
                return "/view/nurseMainPage.jsp";
            }
        }
        logger.debug("registration page");
        return "/view/registration.jsp";
    }
}
