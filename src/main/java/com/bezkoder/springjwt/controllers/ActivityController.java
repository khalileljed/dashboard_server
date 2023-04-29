package com.bezkoder.springjwt.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.springjwt.models.Activity;
import com.bezkoder.springjwt.repository.ActivityRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class ActivityController {
	@Autowired
	  ActivityRepository activityRepository;

	  @GetMapping("/activities")
	  public ResponseEntity<List<Activity>> getAllActivities(@RequestParam(required = false) String title) {
		  try {
		      List<Activity> activities = new ArrayList<Activity>();

		      if (title == null)
		    	  activityRepository.findAll().forEach(activities::add);
		      else
		    	  activityRepository.findByTitleContaining(title).forEach(activities::add);

		      if (activities.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }

		      return new ResponseEntity<>(activities, HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	  }

	  @GetMapping("/activities/{id}")
	  public ResponseEntity<Activity> getActivityById(@PathVariable("id") long id) {
		  Optional<Activity> activityData = activityRepository.findById(id);

		    if (activityData.isPresent()) {
		      return new ResponseEntity<>(activityData.get(), HttpStatus.OK);
		    } else {
		      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		    }
	  }

	  @PostMapping("/activities")
	  public ResponseEntity<Activity> createActivity(@RequestBody Activity activity) {
		  try {
			  Activity _activity = activityRepository.save(new Activity(activity.getTitle(), activity.getBody(), activity.getGroupe()));
		      return new ResponseEntity<>(_activity, HttpStatus.CREATED);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	  }

	  @PutMapping("/activities/{id}")
	  public ResponseEntity<Activity> updateActivity(@PathVariable("id") long id, @RequestBody Activity activity) {
		  Optional<Activity> activitylData = activityRepository.findById(id);

		    if (activitylData.isPresent()) {
		    	Activity _tutorial = activitylData.get();
		      _tutorial.setTitle(activity.getTitle());
		      _tutorial.setBody(activity.getBody());
		      _tutorial.setGroupe(activity.getGroupe());
		      return new ResponseEntity<>(activityRepository.save(_tutorial), HttpStatus.OK);
		    } else {
		      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		    }
	  }

	  @DeleteMapping("/activities/{id}")
	  public ResponseEntity<HttpStatus> deleteActivity(@PathVariable("id") long id) {
		  try {
			  activityRepository.deleteById(id);
		      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		    } catch (Exception e) {
		      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	  }

	  @DeleteMapping("/activities")
	  public ResponseEntity<HttpStatus> deleteAllActivities() {
		  try {
			  activityRepository.deleteAll();
		      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		    } catch (Exception e) {
		      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	  }
	}
