package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;
import model.PatientDiagnosEntity;
public interface IPatientDiagnosDAO {

	    public PatientDiagnosEntity create(ResultSet rs);

	    public List<PatientDiagnosEntity> getByIdPatient(int key);

	    public List<PatientDiagnosEntity> getByIdDoctor(int key);

	    public List<PatientDiagnosEntity> getForNurse();

	    public boolean update(PatientDiagnosEntity object);

	    public boolean add(PatientDiagnosEntity object, Connection connection);

	    public void delete(PatientDiagnosEntity object, Connection connection);

	    public List<PatientDiagnosEntity> getAll();
}
