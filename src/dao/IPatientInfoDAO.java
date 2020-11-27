package dao;

import java.sql.ResultSet;
import java.util.List;
import model.PatientInfoEntity;
public interface IPatientInfoDAO {
	
	    public boolean addNewPatient(PatientInfoEntity patient);

	    public PatientInfoEntity create(ResultSet rs);

	    public PatientInfoEntity getByPK(int key);

	    public boolean checkEmail(String email);

	    public PatientInfoEntity login(String email, String password);

	    public boolean update(PatientInfoEntity object);

	    public void delete(PatientInfoEntity object);

	    public List<PatientInfoEntity> getAll();
}
