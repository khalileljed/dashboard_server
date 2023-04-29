package com.bezkoder.springjwt.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bezkoder.springjwt.models.Groupe;
@Repository
public interface GroupeRepository extends JpaRepository<Groupe, Long> {
	List<Groupe> findByNameContaining(String name);
}
