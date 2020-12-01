package controller;

import com.mysql.jdbc.exceptions.MySQLDataException;
import dao.*;
import model.*;


import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ann_ on 25.02.15.
 */
public class SetDiagnosisLogic {
 

    private IPatientInfoDAO patientDao;
    private IPatientDiagnosDAO patientDiagnosisDao;
    private IDiagnosEntityDAO diagnosisInfoDao;
    private IRecipeDAO prescriptionDao;
    private IReceptionDAO receptionDao;

    private List<PatientInfoEntity> patient;
    private StaffInfoEntity staffInfo;

    public SetDiagnosisLogic(IFactoryDAO daoFactory, StaffInfoEntity staffInfo) {
        this.staffInfo = staffInfo;
        this.patientDao = daoFactory.getPatientInfoDAO();
        this.patientDiagnosisDao = daoFactory.getPatientDiagnosDAO();
        this.diagnosisInfoDao = daoFactory.getDiagnosEntityDAO();
        this.prescriptionDao = daoFactory.getRecipeDAO();
        this.receptionDao = daoFactory.getReceptionDAO();
    }

    public Map<Integer,PatientInfoEntity> getAllPatientInfo() {
        patient = patientDao.getAll();
        Map<Integer,PatientInfoEntity> map = new HashMap<Integer, PatientInfoEntity>();

        for(PatientInfoEntity p : patient) {
            map.put(p.getIdPatient(),p);
        }
     //   logger.debug(map);
        return map;
    }

    public Map<String,Wrapper> getAllHealthyPatientInfo() {
        patient = patientDao.getAll();
        List<PatientDiagnosEntity> patientsDiagnosisEntities = patientDiagnosisDao.getAll();
        Map<String,Wrapper> map = new HashMap<String, Wrapper>();
        for(PatientInfoEntity p : patient) {
            for (PatientDiagnosEntity pd: patientsDiagnosisEntities){
                if (pd.getIdPatient().equals(p.getIdPatient()) && pd.getIdDoctor().equals(staffInfo.getIdStaff())
                && pd.getCurrentRecipe().equals(1)) {
                    Wrapper wrapper = new Wrapper();
                    wrapper.setPatientsDiagnosisEntity(pd);
                    wrapper.setPatientInfoEntity(p);
                    map.put(pd.getIdReception().toString(), wrapper);
                }
            }

        }
        //logger.debug(map);
        return map;
    }

    public Map<Integer,DiagnosEntity> getAllDiagnosis() {
        List<DiagnosEntity> diagnosisInfo = diagnosisInfoDao.getAll();
        Map<Integer,DiagnosEntity> map = new HashMap<Integer, DiagnosEntity>();
        for(DiagnosEntity p : diagnosisInfo) {
            map.put(p.getIdDiagnosis(),p);
        }
        //logger.debug(map);
        return map;
    }

    public Map<Integer,RecipeEntity> getAllPrescriptions() {
        List<RecipeEntity> prescriptionEntities = prescriptionDao.getAll();
        Map<Integer,RecipeEntity> map = new HashMap<Integer, RecipeEntity>();
        for(RecipeEntity p : prescriptionEntities) {
            map.put(p.getIdPrescription(),p);
        }
        //logger.debug(map);
        return map;
    }

    public boolean setDiagnosis(Integer idPatient, Integer idPrescription, Integer idDiagnosisInfo) {
        Connection conn = ConnectionPool.getConnection();
        PatientInfoEntity patient = patientDao.getByPK(idPatient);
        DiagnosEntity diagnosisInfo = diagnosisInfoDao.getByPK(idDiagnosisInfo);
        RecipeEntity prescription = prescriptionDao.getByPK(idPrescription);
        boolean setDiagnosis = false;
        PatientDiagnosEntity patientsDiagnosisEntity = new PatientDiagnosEntity();
        patientsDiagnosisEntity.setIdPatient(patient.getIdPatient());
        patientsDiagnosisEntity.setIdDoctor(staffInfo.getIdStaff());
        patientsDiagnosisEntity.setIdDiagnosis(diagnosisInfo.getIdDiagnosis());
        patientsDiagnosisEntity.setDate(Date.valueOf(LocalDate.now()));
        patientsDiagnosisEntity.setInitialRecipe(prescription.getIdPrescription());
        patientsDiagnosisEntity.setCurrentPrescription(prescription.getIdPrescription());

        ReseptionInfoEntity receptionEntity = new ReseptionInfoEntity();
        receptionEntity.setIdPatient(patient.getIdPatient());
        receptionEntity.setIdDoctor(staffInfo.getIdStaff());
        receptionEntity.setDateOfAdmission(Date.valueOf(LocalDate.now()));
        try {
            conn.setAutoCommit(false);
            int i;
            i = receptionDao.add(receptionEntity, conn);

            if (i == 0 ){
                throw new MySQLDataException();
            }
            patientsDiagnosisEntity.setIdReception(i);
            setDiagnosis = patientDiagnosisDao.add(patientsDiagnosisEntity, conn);

            conn.commit();
            return setDiagnosis;
        } catch (SQLException e) {
            //logger.error(e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
          //      logger.error(e.getMessage());
                e.printStackTrace();
            }
        }
        //logger.debug(setDiagnosis);
        return setDiagnosis;
    }
}
