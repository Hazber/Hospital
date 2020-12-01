package controller;


import dao.IPatientDiagnosDAO;
import model.StaffInfoEntity;
//import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;


public class MakeProcedure extends Command {

//    public static final Logger logger = Logger.getLogger(MakeProcedure.class);

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        StaffInfoEntity staffInfo = (StaffInfoEntity) req.getSession().getAttribute("staff_info");
        String key = req.getParameter("info");
        Map<String,Wrapper> map = (Map<String,Wrapper>) req.getSession().getAttribute("info_about_patient");
        Wrapper wrapper = map.get(key);
        //logger.debug(wrapper);
        int i = wrapper.getCurrentRecipe().getIdPrescription();
        switch (i){
            case 3: i = 1; break;
            case 5: i = 2; break;
            case 6: i = 4; break;
            case 8: i = 7; break;
        }
        wrapper.getPatientsDiagnosisEntity().setCurrentPrescription(i);
        wrapper.getPatientsDiagnosisEntity().setCurrentPrescription(i);
        IPatientDiagnosDAO diagnosisDao = factoryDAO.getPatientDiagnosDAO();
        diagnosisDao.update(wrapper.getPatientsDiagnosisEntity());
        StaffLogic logic = new StaffLogic(factoryDAO, staffInfo);
        logger.debug(wrapper);
        if (staffInfo.getTypeStaff().equals("Doctor")){
            req.getSession().setAttribute("info_about_patient", logic.getAllPatientsInfoForDoctor());
            logger.debug("doctor main page");
            return "/view/doctorMainPage.jsp";
        }
        req.getSession().setAttribute("info_about_patient", logic.getPatientsInfoForNurse());
        logger.debug("nurse main page");
        return "/view/nurseMainPage.jsp";
    }
}
