package com.comet.app.serviceimpimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comet.app.models.History;
import com.comet.app.repositories.HistoryRepository;

@Service
public class HistoryService {

	@Autowired
	private HistoryRepository historyRepository;
	
	public List<History> findAll() {
		return historyRepository.findAll();
	}

	public History save(History history) {
		return historyRepository.save(history);
	}

	public void deleteAll() {
		historyRepository.deleteAll();
	}

	public List<History> findByTag(String tag) {
		return historyRepository.findByTag(tag);
	}

	public boolean existsByTag(String tag) {
		return historyRepository.existsByTag(tag);
	}

}
