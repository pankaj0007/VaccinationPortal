package com.pankaj.vaccination.center.repostories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pankaj.vaccination.center.entity.VaccinationCenter;

public interface CenterRepo extends JpaRepository<VaccinationCenter, Integer>{

}
