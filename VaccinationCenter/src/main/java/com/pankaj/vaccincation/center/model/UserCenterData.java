package com.pankaj.vaccincation.center.model;

import java.util.List;

import com.pankaj.vaccination.center.entity.VaccinationCenter;
import com.pankaj.vaccination.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserCenterData {

	private VaccinationCenter center;
	private List<User> userList;
	public VaccinationCenter getCenter() {
		return center;
	}
	public void setCenter(VaccinationCenter center) {
		this.center = center;
	}
	public List<User> getUserList() {
		return userList;
	}
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	
	
}
