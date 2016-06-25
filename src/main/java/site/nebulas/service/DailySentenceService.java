package site.nebulas.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import site.nebulas.dao.DailySentenceDao;
import site.nebulas.entity.DailySentence;
@Service
public class DailySentenceService {
	@Resource
	private DailySentenceDao dailySentenceDao;
	
	public List<DailySentence> getDailySentenceByParm(DailySentence dailySentence){
		
		return dailySentenceDao.getDailySentenceByParm(dailySentence);
		
	}
}
