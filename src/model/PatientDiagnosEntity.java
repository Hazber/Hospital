package model;
import java.io.Serializable;
import java.sql.Date;

public class PatientDiagnosEntity implements Serializable{
	
	private Integer idPatient;
    private Integer idDoctor;
    private Integer idDiagnos;
    private Date date;
    private Integer initialRecipe;
    private Integer currentRecipe;
    private Integer idReception;
    
    public Integer getIdPatient() {
    //    logger.debug(idPatient);
        return idPatient;
    }

    public void setIdPatient(Integer idPatient) {
      //  logger.debug(idPatient);
        this.idPatient = idPatient;
    }

    public Integer getIdDoctor() {
        //logger.debug(idDoctor);
        return idDoctor;
    }

    public void setIdDoctor(Integer idDoctor) {
        //logger.debug(idDoctor);
        this.idDoctor = idDoctor;
    }

    public Integer getIdDiagnos() {
        //logger.debug(idDiagnos);
        return idDiagnos;
    }

    public void setIdDiagnosis(Integer idDiagnos) {
        //logger.debug(idDiagnosis);
        this.idDiagnos = idDiagnos;
    }

    public Date getDate() {
        //logger.debug(date);
        return date;
    }

    public void setDate(Date date) {
        //logger.debug(date);
        this.date = date;
    }

    public Integer getInitialRecipe() {
        //logger.debug(initialPrescription);
        return initialRecipe;
    }

    public void setInitialRecipe(Integer initialRecipe) {
//        logger.debug(initialPrescription);
        this.initialRecipe = initialRecipe;
    }

    public Integer getCurrentRecipe() {
//        logger.debug(currentPrescriptio);
        return currentRecipe;
    }

    public void setCurrentPrescription(Integer currentRecipe) {
        //logger.debug(currentPrescription);
        this.currentRecipe = currentRecipe;
    }

    public Integer getIdReception() {
        //logger.debug(idReception);
        return idReception;
    }

    public void setIdReception(Integer idReception) {
       // logger.debug(idReception);
        this.idReception = idReception;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PatientDiagnosEntity that = (PatientDiagnosEntity) o;
        //PatientDiagnosisEntity that = (PatientsDiagnosisEntity) o;

        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (idDiagnos != null ? !idDiagnos.equals(that.idDiagnos) : that.idDiagnos != null) return false;
        if (idDoctor != null ? !idDoctor.equals(that.idDoctor) : that.idDoctor != null) return false;
        if (idPatient != null ? !idPatient.equals(that.idPatient) : that.idPatient != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idPatient != null ? idPatient.hashCode() : 0;
        result = 31 * result + (idDoctor != null ? idDoctor.hashCode() : 0);
        result = 31 * result + (idDiagnos != null ? idDiagnos.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }


}
