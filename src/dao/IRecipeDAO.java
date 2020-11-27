package dao;

import java.sql.ResultSet;
import java.util.List;
import model.RecipeEntity;
public interface IRecipeDAO {
	
	    public RecipeEntity create(ResultSet rs);

	    public RecipeEntity getByPK(int key);

	    public boolean update(RecipeEntity object);

	    public void delete(RecipeEntity object);

	    public List<RecipeEntity> getAll();

}
