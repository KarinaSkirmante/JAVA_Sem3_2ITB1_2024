package service;

import java.util.ArrayList;
import java.util.Arrays;

import model.Page;
import model.Post;
import model.PostType;
import model.user.BusinessUser;
import model.user.GuestUser;
import model.user.PrivateUser;

public class MainService {

	//TODO mainīt pieejamības līmeni
	private static ArrayList<GuestUser> allUsers = new ArrayList<GuestUser>();
	
	public static void main(String[] args) {
		GuestUser u1 = new GuestUser();
		GuestUser u2 = new GuestUser();
		PrivateUser u3 = new PrivateUser();
		GuestUser u4 = new GuestUser();
		BusinessUser u5 = new BusinessUser();
		PrivateUser u6 = new PrivateUser("Karina", "Šķirmante", "123456Ka");
		BusinessUser u7  = new BusinessUser("SIA Hesburger", "12345678He", "LV12345678909");
		
		allUsers.addAll(Arrays.asList(u1, u2, u3, u4, u5, u6, u7));
		
		for(GuestUser tempU : allUsers) {
			System.out.println(tempU);
		}
		
		try {
			u6.publishPost(PostType.privatePost, "Man nekas nepatīk!");
			u6.publishPost(PostType.publicPost, "Man viss patīk!");
			u6.publishPost(PostType.publicPost, "Žēl, ka šodien nav piektdiena!");
			
			u6.followPrivateUser(u3);
			u6.followPrivateUser(u7);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("---------------------------------------");
		System.out.println(u6.getUsername() + ": private posts ->");
		System.out.println(u6.getPrivatePosts());
		
		System.out.println(u6.getUsername() + ": public posts ->");
		System.out.println(u6.getPublicPosts());
		
		System.out.println(u6.getUsername() + ": followers ->");
		System.out.println(u6.getFollowers());
		
		
		try {
			u7.createPage("Hesburgers Ventspils", "Jaunumi par Hesburgeru Ventspilī");
			u7.createPage("Hesburgers Daugavpils", "Jaunumi par Hesburgeru Daugavpilī");
			
			u7.publishPostInPage("Hesburgers Ventspils", "20% atlaide visiem siera burgeriem Ventspilī");
			u7.publishPostInPage("Hesburgers Ventspils", "50% atlaide visiem bērna komplektiem Ventspilī");
			u7.publishPostInPage("Hesburgers Daugavpils", "10% atlaide fri");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("---------------------------------------");
		System.out.println(u7.getUsername() + ": pages ->");
		for(Page tempP: u7.getListOfPages())
		{
			System.out.println(tempP + " -->");
			System.out.println(tempP.getPostsInPage());
			System.out.println();
		}
		
		
		
		
		
		
		
		
	}

}
