package dao;
import model.ReseptionInfoEntity;

import java.sql.*;
import java.util.List;
public class SQLReseptionInfoEntityDAO implements IReceptionDAO{
	
	Connection connection;

    @Override
    public ReseptionInfoEntity create(ResultSet rs) {
        return null;
    }

    @Override
    public ReseptionInfoEntity getByPK(int key) {
        return null;
    }

    @Override
    public boolean update(ReseptionInfoEntity object, Connection connection) {
    	 this.connection = connection;
        String sql =Queries.UPDATE_RECEPTION_RECORD;
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(sql);
            statement.setDate(1, object.getDateOfDischarge());
            statement.setInt(2, object.getIdFinalDiagnosis());
            statement.setInt(3, object.getIdRegistration());
            if (statement.executeUpdate() == 1){
                //logger.debug("update successful");
                return true;
            }
        } catch (SQLException e) {
            //logger.error(e.getMessage());
            e.printStackTrace();
        }
        //logger.debug("update failed");
        return false;
    }

    @Override
    public void delete(ReseptionInfoEntity object) {

    }

    @Override
    public Integer add(ReseptionInfoEntity object, Connection connection) {
        connection = ConnectionPool.getConnection();
        String sql = Queries.ADD_NEW_RECEPTION_RECORD;
        PreparedStatement statement;
        ResultSet res = null;
        Integer i = 0;
        try {
            statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(2, object.getIdPatient());
            statement.setInt(3, object.getIdDoctor());
            statement.setDate(1, object.getDateOfAdmission());
            statement.executeUpdate();
            res = statement.getGeneratedKeys();
            res.next();
            i = res.getInt(1);
          //  logger.debug(i);
            return i;
        } catch (SQLException e) {
           // logger.error(e.getMessage());
            e.printStackTrace();
        } finally {
            closeResultSet(res);
            closeConnection();
        }
        return i;
    }

    @Override
    public List<ReseptionInfoEntity> getAll() {
        return null;
    }

    private void closeConnection() {
        if (connection != null) {
            try {
                //logger.debug("close connection");
                connection.close();
            } catch (SQLException e) {
                //logger.error(e.getMessage());
                e.printStackTrace();
            }
        }
    }

    private void closeResultSet(ResultSet rs) {
        if (rs != null) {
            try {
   
                rs.close();
            } catch (SQLException e) {
        
                e.printStackTrace();
            }
        }
    }
}
