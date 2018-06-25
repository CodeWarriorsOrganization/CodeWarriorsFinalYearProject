package com.codewarriors.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.codewarriors.entities.HistoricalWinners;

@Repository
public interface HistoricalWinnersRepo extends JpaRepository<HistoricalWinners, Integer>{

}
