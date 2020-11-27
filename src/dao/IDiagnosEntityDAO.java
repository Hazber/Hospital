package dao;

import java.sql.ResultSet;
import java.util.List;
import model.DiagnosEntity;

public interface IDiagnosEntityDAO {

    public DiagnosEntity create(ResultSet rs);

    public DiagnosEntity getByPK(int key);

    public boolean update(DiagnosEntity object);

    public void delete(DiagnosEntity object);

    public List<DiagnosEntity> getAll();
}
