package controller;

import dao.*;
import model.*;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class StaffLogic {

    
    private IPatientInfoDAO patientDao;
    private IPatientDiagnosDAO patientDiagnosisDao;
    private IDiagnosEntityDAO diagnosisInfoDao;
    private IRecipeDAO prescriptionDao;

    private List<PatientDiagnosEntity> diagnosisList;
    private StaffInfoEntity staffInfo;

    public StaffLogic(IFactoryDAO daoFactory, StaffInfoEntity staffInfoEntity) {
        this.patientDiagnosisDao = daoFactory.getPatientDiagnosDAO();
        this.diagnosisInfoDao = daoFactory.getDiagnosEntityDAO();
        this.staffInfo = staffInfoEntity;
        this.prescriptionDao = daoFactory.getRecipeDAO();
        this.patientDao = daoFactory.getPatientInfoDAO();
    }

    public Map<String,Wrapper> getAllPatientsInfoForDoctor() {
        diagnosisList = patientDiagnosisDao.getByIdDoctor(staffInfo.getIdStaff());
       
        return fillMap(diagnosisList);
    }

    public Map<String,Wrapper> getPatientsInfoForNurse() {
        diagnosisList = patientDiagnosisDao.getForNurse();
       
        return fillMap(diagnosisList);
    }

    private Map<String, Wrapper> fillMap(List<PatientDiagnosEntity> diagnosisList) {
        Map<String,Wrapper> list = new HashMap<String, Wrapper>();
        Wrapper wrapper;
        if (diagnosisList == null) {
            return list;
        }
        for (int i = 0; i < diagnosisList.size(); i++) {
            wrapper = new Wrapper();
            PatientInfoEntity patient = patientDao.getByPK(diagnosisList.get(i).getIdPatient());
            wrapper.setPatientInfoEntity(patient);

            DiagnosEntity diagnosisInfo = diagnosisInfoDao.getByPK(diagnosisList.get(i).getIdDiagnos());
            wrapper.setDiagnosisInfoEntity(diagnosisInfo);

            RecipeEntity prescription = prescriptionDao.getByPK(diagnosisList.get(i).getInitialRecipe());
            wrapper.setInitialPrescription(prescription);

            prescription = prescriptionDao.getByPK(diagnosisList.get(i).getCurrentRecipe());
            wrapper.setCurrentRecipe(prescription);

            wrapper.setPatientsDiagnosisEntity(diagnosisList.get(i));
            list.put(patient.getIdPatient().toString() + diagnosisList.get(i).getIdDoctor()
                    + diagnosisInfo.getIdDiagnosis(), wrapper);

        }
      
        return list;
    }
}
