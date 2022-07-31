package com.dsic.FicheInfo.services;

import com.dsic.FicheInfo.entities.AppRole;
import com.dsic.FicheInfo.entities.AppUser;

public interface AccountService {

	public AppUser save(AppUser user);
	public AppRole saveRole(AppRole role);
	public void addRoleToUser(String username,String roleName);
	public AppUser finduserByUsrname(String username);
}
