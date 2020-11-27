package dao;

public class SQLFactoryDAO implements IFactoryDAO{
	 @Override
	    public IPatientInfoDAO getPatientInfoDao() {
	        //logger.debug("patient dao");
	        return new SQLPatientInfoDAO();
	    }

	    @Override
	    public IStaffDAO getStaffDao() {
	        //logger.debug("staff dao");
	        return new SQlStaffDAO();
	    }

	    @Override
	    public IPatientDiagnosDAO getPatientDiagnosDao() {
	      //  logger.debug("patient diagnosis dao");
	        return new SQLPatientDiagnosDAO();
	    }

	    @Override
	    public IDiagnosEntityDAO getDiagnosEntityDAO() {
	        //logger.debug("diagnosis info dao");
	        return new SQLDiagnosEntityDAO();
	    }

	    @Override
	    public IRecipeDAO getRecipeDAO() {
	        //logger.debug("prescription info dao");
	        return new SQLRecipeDAO();
	    }

	    @Override
	    public IReceptionDAO getReceptionDAO() {
	        //logger.debug("reception dao");
	        return new SQLReseptionInfoEntityDAO();
	    }
	
}
