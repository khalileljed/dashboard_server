package com.bezkoder.springjwt.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import com.bezkoder.springjwt.models.Activity;
@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {
	List<Activity> findByPublished(boolean published);
	List<Activity> findByTitleContaining(String title);
}
