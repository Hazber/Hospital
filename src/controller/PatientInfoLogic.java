package controller;

import dao.*;
import model.*;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PatientInfoLogic {
    
 //   public static final Logger logger = Logger.getLogger(PatientInfoLogic.class);

    private IFactoryDAO daoFactory;
    private IPatientDiagnosDAO patientDiagnosisDao;
    private IDiagnosEntityDAO diagnosInfoDAO;
    private IStaffDAO staffDao;
    private IRecipeDAO prescriptionDao;

    private PatientInfoEntity patient;
    private List<PatientDiagnosEntity> patientsDiagnosis;
    private DiagnosEntity diagnosisInfo;
    private StaffInfoEntity staffInfo;
    private RecipeEntity prescription;

    public PatientInfoLogic(IFactoryDAO factory, PatientInfoEntity patient) {
        this.daoFactory = factory;
        this.patient = patient;
        this.patientDiagnosisDao = daoFactory.getPatientDiagnosDAO();
        this.diagnosInfoDAO=daoFactory.getDiagnosEntityDAO() ;
        this.staffDao = daoFactory.getStaffDAO();
        this.prescriptionDao = daoFactory.getRecipeDAO();
    }

    public Map<String,Wrapper> getPatientInfo() {
        Map<String,Wrapper> map = new HashMap<String, Wrapper>();
        Wrapper wrapper = null;
        patient.setPatientsDiagnosis(patientDiagnosisDao.getByIdPatient(patient.getIdPatient()));
        patientsDiagnosis = patient.getPatientsDiagnosis();

       // logger.debug(patientsDiagnosis);

        if (patientsDiagnosis == null) {
            return map;
        }
        for (int i = 0; i < patientsDiagnosis.size(); i++) {
            wrapper = new Wrapper();
            staffInfo = staffDao.getByPK(patientsDiagnosis.get(i).getIdDoctor());
            wrapper.setStaffInfoEntity(staffInfo);

            diagnosisInfo = diagnosInfoDAO.getByPK(patientsDiagnosis.get(i).getIdDiagnos());
            wrapper.setDiagnosisInfoEntity(diagnosisInfo);

            prescription = prescriptionDao.getByPK(patientsDiagnosis.get(i).getInitialRecipe());
            wrapper.setInitialPrescription(prescription);

            prescription = prescriptionDao.getByPK(patientsDiagnosis.get(i).getCurrentRecipe());
            wrapper.setCurrentRecipe(prescription);
            map.put(patient.getIdPatient().toString(), wrapper);
        }
        return map;
    }
}
