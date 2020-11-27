package dao;
import model.DiagnosEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLDiagnosEntityDAO implements IDiagnosEntityDAO{
	 private PreparedStatement statement;
	    private Connection connection;

	    public SQLDiagnosEntityDAO() {
	    }

	    @Override
	    public DiagnosEntity create(ResultSet rs) {
	        DiagnosEntity pi = new DiagnosEntity();
	        try {
	            pi.setIdDiagnosis(rs.getInt("ID_Diagnosis"));
	            pi.setName(rs.getString("Name"));
	            pi.setDescription(rs.getString("Description"));
	        } catch (SQLException e) {
	          
	            e.printStackTrace();
	            return null;
	        }
	     //   logger.debug(pi);
	        return pi;
	    }

	    @Override
	    public DiagnosEntity getByPK(int key) {
	        ResultSet rs = null;
	        statement = null;
	        connection = ConnectionPool.getConnection();
	        try {
	            statement = connection.prepareStatement(Queries.GET_DIAGNOSIS_INFO_BY_ID);
	            statement.setInt(1, key);
	            rs = statement.executeQuery();
	            DiagnosEntity pi = null;
	            if (rs.next()) {
	                pi = create(rs);
	            }
	            //logger.debug(pi);
	            return pi;
	        } catch (SQLException e) {
	            //logger.error(e.getMessage());
	            e.printStackTrace();
	        } finally {
	            closeConnection();
	            closeResultSet(rs);
	        }
	        return null;
	    }

	    @Override
	    public boolean update(DiagnosEntity object) {
	        return false;
	    }

	    @Override
	    public void delete(DiagnosEntity object) {

	    }

	    @Override
	    public List<DiagnosEntity> getAll() {
	        ResultSet rs = null;
	        statement = null;
	        connection = ConnectionPool.getConnection();
	        try {
	            statement = connection.prepareStatement(Queries.GET_ALL_DIAGNOSIS);
	            rs = statement.executeQuery();
	            List<DiagnosEntity> pi = new ArrayList<DiagnosEntity>();
	            while (rs.next()) {
	                pi.add(create(rs));
	            }
	           // logger.debug(pi);
	            return pi;
	        } catch (SQLException e) {
	            //logger.error(e.getMessage());
	            e.printStackTrace();
	            return null;
	        } finally {
	            closeConnection();
	            closeResultSet(rs);
	        }
	    }

	    private void closeConnection() {
	        if (connection != null) {
	            try {
	             //   logger.debug("close connection");
	                connection.close();
	            } catch (SQLException e) {
	               // logger.error(e.getMessage());
	                e.printStackTrace();
	            }
	        }
	    }

	    private void closeResultSet(ResultSet rs) {
	        if (rs != null) {
	            try {
	              //  logger.debug("close result set");
	                rs.close();
	            } catch (SQLException e) {
	              // logger.error(e.getMessage());
	                e.printStackTrace();
	            }
	        }
	    }
}
