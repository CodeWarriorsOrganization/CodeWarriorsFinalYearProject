package com.codewarriors.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.codewarriors.entities.Transaction;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Integer> {

	Transaction findByPlayerName(String name);

	List<Transaction> findAllByPlayerName(String pName);

	List<Transaction> findAllByCompName(String compName);

	@Query("SELECT DISTINCT compName FROM Transaction WHERE playerName =:playerName")
	List<String> findDistinctCompanies(@Param("playerName") String playerName);

	@Query("SELECT t FROM Transaction t WHERE t.playerName =:playerName AND t.compName =:compName AND t.type = :type")
	List<Transaction> findDistinctCompaniesWithType(@Param("playerName") String playerName,
			@Param("compName") String compName, @Param("type") String type);

	@Query("SELECT t FROM Transaction t WHERE t.playerName =:playerName")
	List<Transaction> findRecordByPlayer(@Param("playerName") String playerName);

	@Query("SELECT t FROM Transaction t WHERE t.type =:type")
	List<Transaction> findRecordByType(@Param("type") String type);

}
