package dao;
import org.apache.log4j.Logger;

public class SQLFactoryDAO implements IFactoryDAO{
	public static final Logger logger = Logger.getLogger(SQLFactoryDAO.class);
	 @Override
	    public IPatientInfoDAO getPatientInfoDAO() {
	        logger.debug("patient dao");
	        return new SQLPatientInfoDAO();
	    }

	    @Override
	    public IStaffDAO getStaffDAO() {
	        logger.debug("staff dao");
	        return new SQlStaffDAO();
	    }

	    @Override
	    public IPatientDiagnosDAO getPatientDiagnosDAO() {
	         logger.debug("patient diagnosis dao");
	        return new SQLPatientDiagnosDAO();
	    }

	    @Override
	    public IDiagnosEntityDAO getDiagnosEntityDAO() {
	        logger.debug("diagnosis info dao");
	        return new SQLDiagnosEntityDAO();
	    }

	    @Override
	    public IRecipeDAO getRecipeDAO() {
	        logger.debug("prescription info dao");
	        return new SQLRecipeDAO();
	    }

	    @Override
	    public IReceptionDAO getReceptionDAO() {
	        logger.debug("reception dao");
	        return new SQLReseptionInfoEntityDAO();
	    }
	
}
