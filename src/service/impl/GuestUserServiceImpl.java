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
	public ArrayList<Page> findPages(String titleOrDescription) throws Exception {
		if(titleOrDescription == null || titleOrDescription.length() < 2)
			throw new Exception("Problems with input arg");
		
		ArrayList<Page> foundPages = new ArrayList<Page>();
		
		for(GuestUser tempU : MainService.allUsers) {
			if(tempU instanceof BusinessUser) {
				BusinessUser user = (BusinessUser)tempU;
				for(Page tempP: user.getListOfPages()) {
					if(tempP.getTitle().toLowerCase().contains(titleOrDescription.toLowerCase()) ||
							tempP.getDescription().toLowerCase().contains(titleOrDescription.toLowerCase()))
					{
						foundPages.add(tempP);
					}
				}
			}
		}
		
		return foundPages;
	}

	@Override
	public ArrayList<Post> findInfoInPublicPosts(String msg) {
		// TODO Auto-generated method stub
		return null;
	}

}
