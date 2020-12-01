package controller;


import model.StaffInfoEntity;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;


public class GoToDischargePatient extends Command{
    public static final Logger logger = Logger.getLogger(GoToDischargePatient.class);
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws NeedlessTreatmentException {
        SetDiagnosisLogic diagnosisLogic = new SetDiagnosisLogic(daoFactory, (StaffInfoEntity) req.getSession().getAttribute("staff_info"));
        Map map = diagnosisLogic.getAllHealthyPatientInfo();
        logger.debug(map);
        if (map != null) {
            req.getSession().setAttribute("healthy_patient_list", diagnosisLogic.getAllHealthyPatientInfo());
        }
        logger.debug("discharge patient page");
        return "/view/dischargePatient.jsp";
    }
}
