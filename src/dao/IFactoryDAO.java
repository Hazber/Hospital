package dao;

public interface IFactoryDAO {
	
	public IPatientInfoDAO getPatientInfoDao();

    public IStaffDAO getStaffDao();

    public IPatientDiagnosDAO getPatientDiagnosDao();

    public IDiagnosEntityDAO getDiagnosEntityDAO();

    public IRecipeDAO getRecipeDAO();

    public IReceptionDAO getReceptionDAO();

}
