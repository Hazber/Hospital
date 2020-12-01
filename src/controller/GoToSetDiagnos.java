package controller;


import model.StaffInfoEntity;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class GoToSetDiagnos extends Command {

    public static final Logger logger = Logger.getLogger(GoToSetDiagnos.class);

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws NeedlessTreatmentException {
        SetDiagnosisLogic diagnosisLogic = new SetDiagnosisLogic(factoryDAO, (StaffInfoEntity) req.getAttribute("staff_info"));
        req.setAttribute("patient_list", diagnosisLogic.getAllPatientInfo());
        req.setAttribute("diagnosis_list", diagnosisLogic.getAllDiagnosis());
        req.setAttribute("prescription_list", diagnosisLogic.getAllPrescriptions());
        logger.debug("set diagnosis page");
        return "/view/setDiagnosis.jsp";
    }
}
