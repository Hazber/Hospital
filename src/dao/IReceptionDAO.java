package dao;

import model.ReseptionInfoEntity;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

public interface IReceptionDAO {
	
	public ReseptionInfoEntity create(ResultSet rs);

    public ReseptionInfoEntity getByPK(int key);

    public boolean update(ReseptionInfoEntity object, Connection connection);

    public void delete(ReseptionInfoEntity object);

    public Integer add(ReseptionInfoEntity object, Connection connection);

    public List<ReseptionInfoEntity> getAll();
	
	
}
