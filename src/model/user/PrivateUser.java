package model.user;

import java.util.ArrayList;

import model.Post;
import model.PostType;

public class PrivateUser extends User{

	//1. variables
	private ArrayList<Post> privatePosts = new ArrayList<Post>();
	private ArrayList<Post> publicPosts = new ArrayList<Post>();
	private ArrayList<User> followers = new ArrayList<User>();
	//2. get and set
	public ArrayList<Post> getPrivatePosts() {
		return privatePosts;
	}

	public ArrayList<Post> getPublicPosts() {
		return publicPosts;
	}

	public ArrayList<User> getFollowers() {
		return followers;
	}
	
	@Override
	public void setNameAndSurnameOrTitle(String nameAndSurnameOrTitle) {
		if(nameAndSurnameOrTitle != null && 
nameAndSurnameOrTitle.matches("[A-ZĒŪĪĻĶĢŠĀČŅ]{1}[a-zēūīļķģšāžčņ]+ [A-ZĒŪĪĻĶĢŠĀČŅ]{1}[a-zēūīļķģšāžčņ]+")) 
			super.nameAndSurnameOrTitle = nameAndSurnameOrTitle;
		
		else
			super.nameAndSurnameOrTitle = "-----";
		}
	
	//3. constructors
	public PrivateUser() {
		super();//User()
		setNameAndSurnameOrTitle("Jānis Bērziņš");
		setUsername();	
	}
	
	
	public PrivateUser(String name, String surname, String password) {
		super(password);//User(String password)
		setNameAndSurnameOrTitle(name + " " + surname);
		setUsername();
		
	}
	
	
	//4. toString
	public String toString() {
		return super.toString() + "[" +(privatePosts.size() + publicPosts.size()) + " posts]";
	}
	
	
	
	
	//5. other functions
	
	
	
	@Override
	public Post publishPost(PostType type, String msg) throws Exception{
		// veic pārbaudi uz not null abiem input mainīgajiem un izmet izņēmumu
		if(type == null || msg ==  null) throw new Exception("Problems with input params");
		
		//izveidojam Post objektu
		Post newPost = new Post(msg);
		
		//ja type ir private, tad izveidoto Post objektu ieliek zem privatePosts
		if(type.equals(PostType.privatePost)) privatePosts.add(newPost);
		
		//ja type ir public, tad izveidoto Post objektu ieliek zem publicPosts
		else if(type.equals(PostType.publicPost)) publicPosts.add(newPost);
			
		return newPost;
		
	}

	public void followPrivateUser(User user) throws Exception{
		//pārbaudam, ka user not null
		if(user == null) throw new Exception("Problems with input params");
		
		//TODO pārbaudam, ka user jau nav mūsu sekotaju sarakstā
		for(User tempUser: followers) {
			if(tempUser.getUsername().equals(user.getUsername())) {
				throw new Exception("This user is already as follower");
			}
		}
		//TODO ja anv, tad pievienojam followers sarakstā
		followers.add(user);

		
	}



}
