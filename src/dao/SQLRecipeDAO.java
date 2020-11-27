package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.RecipeEntity;
public class SQLRecipeDAO  implements IRecipeDAO{
	 private PreparedStatement statement;
	    private Connection connection;

	    @Override
	    public RecipeEntity create(ResultSet rs) {
	        RecipeEntity pi = new RecipeEntity();
	        try {
	            pi.setIdPrescription(rs.getInt("ID_Prescription"));
	            pi.setTablets(rs.getString("Drugs"));
	            pi.setOperation(rs.getString("Operation"));
	            pi.setProcedure(rs.getString("Procedure"));
	        } catch (SQLException e) {
	            //logger.error(e.getMessage());
	            e.printStackTrace();
	            return null;
	        }
	      //  logger.debug(pi);
	        return pi;
	    }

	    @Override
	    public RecipeEntity getByPK(int key) {
	        ResultSet rs = null;
	        statement = null;

	        connection = ConnectionPool.getConnection();
	        try {
	            statement = connection.prepareStatement(Queries.GET_RECIPE_INFO_BY_ID);
	            statement.setInt(1, key);
	            rs = statement.executeQuery();
	            RecipeEntity pi = null;
	            if (rs.next()) {
	                pi = create(rs);
	            }
	         //   logger.debug(pi);
	            return pi;
	        } catch (SQLException e) {
	         //   logger.error(e.getMessage());
	            e.printStackTrace();
	            return null;
	        } finally {
	            closeConnection();
	            closeResultSet(rs);
	        }
	    }

	    @Override
	    public boolean update(RecipeEntity object) {
	        return false;
	    }

	    @Override
	    public void delete(RecipeEntity object) {

	    }

	    @Override
	    public List<RecipeEntity> getAll() {
	        ResultSet rs = null;
	        statement = null;
	        connection = ConnectionPool.getConnection();
	        try {
	            statement = connection.prepareStatement(Queries.GET_ALL_RECIPE);
	            rs = statement.executeQuery();
	            List<RecipeEntity> pi = new ArrayList<RecipeEntity>();
	            while (rs.next()) {
	                pi.add(create(rs));
	            }
	            //logger.debug(pi);
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
	            //    logger.debug("close connection");
	                connection.close();
	            } catch (SQLException e) {
	            //    logger.error(e.getMessage());
	                e.printStackTrace();
	            }
	        }
	    }

	    private void closeResultSet(ResultSet rs) {
	        if (rs != null) {
	            try {
	               // logger.debug("close result set");
	                rs.close();
	            } catch (SQLException e) {
	               // logger.error(e.getMessage());
	                e.printStackTrace();
	            }
	        }
	    }

}
