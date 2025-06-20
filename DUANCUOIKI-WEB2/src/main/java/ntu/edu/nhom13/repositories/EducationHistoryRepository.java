package ntu.edu.nhom13.repositories;

import java.util.List;
import java.util.Optional;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ntu.edu.nhom13.entity.EducationHistory;

@Repository
public interface EducationHistoryRepository extends JpaRepository<EducationHistory, Integer> {

	List<EducationHistory> findByScientistId(Integer scientistId);

	@Transactional
	@Modifying
	@Query("DELETE FROM EducationHistory b WHERE b.scientist.id = :scientistId")
	void deleteByScientist_Id(@Param("scientistId") Integer scientistId);

	Optional<EducationHistory> findByIdAndScientistId(Integer id, Integer scientistId);

}
