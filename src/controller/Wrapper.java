package controller;

import model.*;


import java.io.Serializable;

public class Wrapper implements Serializable {

    private PatientInfoEntity patientInfoEntity;
    private StaffInfoEntity staffInfoEntity;
    private PatientDiagnosEntity patientsDiagnosisEntity;
    private DiagnosEntity diagnosisInfoEntity;
    private RecipeEntity initialPrescription;
    private RecipeEntity currentPrescription;
    private ReseptionInfoEntity receptionEntity;

    public Wrapper() {
    }

    public PatientInfoEntity getPatientInfoEntity() {
        
        return patientInfoEntity;
    }

    public void setPatientInfoEntity(PatientInfoEntity patientInfoEntity) {
        this.patientInfoEntity = patientInfoEntity;
        

    }

    public DiagnosEntity getDiagnosisInfoEntity() {
        
        return diagnosisInfoEntity;
    }

    public void setDiagnosisInfoEntity(DiagnosEntity diagnosisInfoEntity) {
        this.diagnosisInfoEntity = diagnosisInfoEntity;
      
    }

    public StaffInfoEntity getStaffInfoEntity() {
       
        return staffInfoEntity;
    }

    public void setStaffInfoEntity(StaffInfoEntity staffInfoEntity) {
       
        this.staffInfoEntity = staffInfoEntity;
    }

    public PatientDiagnosEntity getPatientsDiagnosisEntity() {
        
        return patientsDiagnosisEntity;
    }

    public void setPatientsDiagnosisEntity(PatientDiagnosEntity patientsDiagnosisEntity) {
        
        this.patientsDiagnosisEntity = patientsDiagnosisEntity;
    }

    public RecipeEntity getInitialPrescription() {
        
        return initialPrescription;
    }

    public void setInitialPrescription(RecipeEntity initialPrescription) {
        this.initialPrescription = initialPrescription;
    }

    public ReseptionInfoEntity getReceptionEntity() {
        
        return receptionEntity;
    }

    public void setReceptionEntity(ReseptionInfoEntity receptionEntity) {
      
        this.receptionEntity = receptionEntity;
    }

    public RecipeEntity getCurrentRecipe() {
        
        return currentPrescription;
    }

    public void setCurrentRecipe(RecipeEntity currentPrescription) {
        
        this.currentPrescription = currentPrescription;
    }
}
