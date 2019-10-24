package com.comet.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comet.app.models.History;

public interface HistoryRepository extends JpaRepository<History, Long>{

	List<History> findByTag(String tag);

	boolean existsByTag(String tag);

}
