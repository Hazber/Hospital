package model;
import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "diagnosis_info", schema = "", catalog = "hospital")

public class DiagnosEntity implements Serializable {



    private Integer idDiagnos;
    private String name;
    private String description;

    @Id
    @Column(name = "ID_Diagnosis")
    public Integer getIdDiagnosis() {
        //logger.debug(idDiagnosis);
        return idDiagnos;
    }

    public void setIdDiagnosis(Integer idDiagnosis) {
        //logger.debug(idDiagnosis);
        this.idDiagnos = idDiagnos;
    }

    @Basic
    @Column(name = "Name")
    public String getName() {
        //logger.debug(name);
        return name;
    }

    public void setName(String name) {
        //logger.debug(name);
        this.name = name;
    }

    @Basic
    @Column(name = "Description")
    public String getDescription() {
        //logger.debug(description);
        return description;
    }

    public void setDescription(String description) {
        //logger.debug(description);
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DiagnosEntity that = (DiagnosEntity) o;

        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (idDiagnos != null ? !idDiagnos.equals(that.idDiagnos) : that.idDiagnos != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idDiagnos != null ? idDiagnos.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }


}
