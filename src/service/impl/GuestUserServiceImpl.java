package service.impl;

import java.util.ArrayList;

import model.Page;
import model.Post;
import model.user.BusinessUser;
import model.user.GuestUser;
import model.user.PrivateUser;
import model.user.User;
import service.IGuestUserService;
import service.MainService;

public class GuestUserServiceImpl implements IGuestUserService{

	@Override
	public ArrayList<User> findUsers(String nameOrSurnameOrTitle) throws Exception {
		if(nameOrSurnameOrTitle == null || nameOrSurnameOrTitle.length() < 2)
			throw new Exception("Problems with input arg");
		
		
		ArrayList<User> foundUsers = new ArrayList<User>();
		for(GuestUser tempU: MainService.allUsers) {
			if(tempU instanceof PrivateUser || tempU instanceof BusinessUser) {
				User user = (User)tempU;
				if(user.getNameAndSurnameOrTitle().toLowerCase().contains(nameOrSurnameOrTitle.toLowerCase())) {
					foundUsers.add(user);
				}
			}
		}
		
		return foundUsers;
	}

	@Override
	public ArrayList<Page> findPages(String titleOrDescription) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Post> findInfoInPublicPosts(String msg) {
		// TODO Auto-generated method stub
		return null;
	}

}
