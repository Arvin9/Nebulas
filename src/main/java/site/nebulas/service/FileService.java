package site.nebulas.service;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import site.nebulas.dao.FileDao;
import site.nebulas.entity.File;
@Service
public class FileService {
	@Resource
	private FileDao fileDao;
	
	public List<File> bookQueryByParam(File file) {
		return fileDao.bookQueryByParam(file);
	}
	public void insert(File file){
		fileDao.insert(file);
	}
	
	public void update(File file){
		fileDao.update(file);
	}
	
	public void delete(File file){
		fileDao.delete(file);
	}
}
