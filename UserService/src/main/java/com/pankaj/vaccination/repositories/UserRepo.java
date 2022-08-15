package com.pankaj.vaccination.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pankaj.vaccination.entity.User;

public interface UserRepo extends JpaRepository<User, Integer>{
	
	public List<User> findByVaccinationCenterId(int id);

}
