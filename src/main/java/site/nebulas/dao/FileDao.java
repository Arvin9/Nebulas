package site.nebulas.dao;

import java.util.List;
import site.nebulas.entity.File;

public interface FileDao {
	
	public List<File> bookQueryByParam(File file);
	public void insert(File file);
	public void update(File file);
	public void delete(File file);
}
