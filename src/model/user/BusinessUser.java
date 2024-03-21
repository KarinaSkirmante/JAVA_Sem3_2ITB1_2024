package model.user;

import java.util.ArrayList;

import model.Page;
import model.Post;
import model.PostType;

public class BusinessUser extends User {

	//1. variablespublishPost
	private String PVNNo;//example: LV40003245752
	private ArrayList<Page> listOfPages = new ArrayList<Page>();
	
	//2. get and set
	public String getPVNNo() {
		return PVNNo;
	}

	//TODO uztaisīt pašiem algorimtu, kas izveido PVNNo
	public void setPVNNo(String pVNNo) {
		if(pVNNo != null && pVNNo.matches("[A-Z]{2}[0-9]{11}"))
			this.PVNNo = pVNNo;
		else
			this.PVNNo = "----------";
	}

	public ArrayList<Page> getListOfPages() {
		return listOfPages;
	}
	
	@Override
	public void setNameAndSurnameOrTitle(String nameAndSurnameOrTitle) {
		if(nameAndSurnameOrTitle != null && nameAndSurnameOrTitle.matches("[A-Za-z0-9%&+@=.,! ]{3,50}"))
			super.nameAndSurnameOrTitle = nameAndSurnameOrTitle;
		else
			super.nameAndSurnameOrTitle = "----------";
		
	}
	
	
	//3. constructors
	public BusinessUser() {
		super(); //tiek izsaukts User() bezargs konstruktors
		setNameAndSurnameOrTitle("AutoServiss");
		setUsername();
		setPVNNo("LV40003245752");
	}
	
	
	public BusinessUser(String title, String password, String PVNNo) {
		super(password);
		setNameAndSurnameOrTitle(title);
		setUsername();
		setPVNNo(PVNNo);
		
	}
	
	
	//4. toString
	public String toString() {
		return super.toString() + " " + PVNNo;
	}
	
	
	
	
	
	//5. other functions
	
	public void createPage(String title, String description) throws Exception{
		//TODO ievades parametrus pārbaudam uz not null
		for(Page tempP: listOfPages) {
			if(tempP.getTitle().equals(title)) {
				throw new Exception("Page already exists");
			}
		}

		listOfPages.add(new Page(title, description));
	}
	
	
	public void publishPostInPage(String pageTitle, String msg) throws Exception {
		//TODO ievades parametrus pārbaudam uz not null
				for(Page tempP: listOfPages) {
					if(tempP.getTitle().equals(pageTitle)) {
						Post newPost = publishPost(PostType.publicPost, msg);
						tempP.getPostsInPage().add(newPost);
						return;
					}
				}
				
				throw new Exception("Page not found");
				
				
	}
	
	
	@Override
	public Post publishPost(PostType type, String msg) throws Exception {
		//TODO ievades parametrus pārbaudam uz not null
		Post newPost = new Post(msg);
		return newPost;
		
	}

	



}
