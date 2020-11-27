package model;
import javax.persistence.*;
import java.io.Serializable;

@Entity//todo: recipe!=precription
@Table(name = "prescription", schema = "", catalog = "hospital")

public class RecipeEntity implements Serializable {


    private Integer idRecipe;
    private String tablets;
    private String procedure;
    private String operation;

    @Id
    @Column(name = "ID_Prescription")
    public Integer getIdPrescription() {
       // logger.debug(idPrescription);
        return idRecipe;
    }

    public void setIdPrescription(Integer idPrescription) {
     //   logger.debug(idPrescription);
        this.idRecipe = idRecipe;
    }

    @Basic
    @Column(name = "Drugs")
    public String getTablets() {
        //logger.debug(drugs);
        return tablets;
    }

    public void setTablets(String tablets) {
        //logger.debug(drugs);
        this.tablets = tablets;
    }

    @Basic
    @Column(name = "Procedure")
    public String getProcedure() {
       // logger.debug(procedure);
        return procedure;
    }

    public void setProcedure(String procedure) {
        //logger.debug(procedure);
        this.procedure = procedure;
    }

    @Basic
    @Column(name = "Operation")
    public String getOperation() {
    //    logger.debug(operation);
        return operation;
    }

    public void setOperation(String operation) {
      //  logger.debug(operation);
        this.operation = operation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeEntity taht = (RecipeEntity) o;
       

        if (tablets != null ? !tablets.equals(that.tablets) : that.tablets != null) return false;
        if (idRecipe != null ? !idRecipe.equals(that.idRecipe) : that.idRecipe != null)
            return false;
        if (operation != null ? !operation.equals(that.operation) : that.operation != null) return false;
        if (procedure != null ? !procedure.equals(that.procedure) : that.procedure != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idRecipe != null ? idRecipe.hashCode() : 0;
        result = 31 * result + (tablets != null ? tablets.hashCode() : 0);
        result = 31 * result + (procedure != null ? procedure.hashCode() : 0);
        result = 31 * result + (operation != null ? operation.hashCode() : 0);
        return result;
    }


}
