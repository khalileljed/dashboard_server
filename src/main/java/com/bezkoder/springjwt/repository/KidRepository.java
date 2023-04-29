package com.bezkoder.springjwt.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bezkoder.springjwt.models.Kid;
@Repository
public interface KidRepository extends JpaRepository<Kid, Long>{

}
