package model.user;

import java.util.ArrayList;

import model.Page;
import model.PostType;

public class BusinessUser extends User {

	//1. variables
	private String PVNNo;//example: LV40003245752
	private ArrayList<Page> listOfPages = new ArrayList<Page>();
	
	//2. get and set
	public String getPVNNo() {
		return PVNNo;
	}

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
		if(nameAndSurnameOrTitle != null && nameAndSurnameOrTitle.matches("[A-Za-z0-9%&+@=.,!]{3,50}"))
			super.nameAndSurnameOrTitle = nameAndSurnameOrTitle;
		else
			super.nameAndSurnameOrTitle = "----------";
		
	}
	
	
	//3. constructors
	
	//4. toString
	
	//5. other functions
	
	@Override
	public void publishPost(PostType type, String msg) throws Exception {
		// TODO Auto-generated method stub
		
	}

	



}
