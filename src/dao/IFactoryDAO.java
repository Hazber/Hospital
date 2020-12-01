package dao;

public interface IFactoryDAO {
	
	public IPatientInfoDAO getPatientInfoDAO();

    public IStaffDAO getStaffDAO();

    public IPatientDiagnosDAO getPatientDiagnosDAO();

    public IDiagnosEntityDAO getDiagnosEntityDAO();

    public IRecipeDAO getRecipeDAO();

    public IReceptionDAO getReceptionDAO();

}
