package controller;

import dao.IFactoryDAO;
import dao.IPatientInfoDAO;
import model.PatientInfoEntity;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;


public class AddNewPatient extends Command {

   

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        String email = request.getParameter("eMail");
        IPatientInfoDAO patientInfoDao= factoryDAO.getPatientInfoDAO();
        //IPatientInfoDAO patientInfoDao = IFactoryDAO.getPatientInfoDao();

        if (patientInfoDao.checkEmail(email)) {
            return "/view/authorization.jsp";
        }
        if (request.getParameter("password").equals(request.getParameter("checkPassword"))){
            PatientInfoEntity newPatient = new PatientInfoEntity();

            newPatient.setName(request.getParameter("firstName"));
            newPatient.setSurname(request.getParameter("lastName"));
            newPatient.seteMail(email);
            newPatient.setBirthday(Date.valueOf(request.getParameter("birthday")));
            newPatient.setPhoneNumber(request.getParameter("phoneNumber"));
            newPatient.setPassword(request.getParameter("password"));
            if (patientInfoDao.addNewPatient(newPatient)) {
        
                request.getSession().setAttribute("patient_info",newPatient);
                return "/view/patientMainPage.jsp";
            }
        }
        return "/view/registration.jsp";
    }
}
