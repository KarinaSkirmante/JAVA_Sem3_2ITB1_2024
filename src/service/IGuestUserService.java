package service;

import java.util.ArrayList;

import model.Page;
import model.Post;
import model.user.User;

public interface IGuestUserService {
	public abstract ArrayList<User> findUsers(String nameOrSurnameOrTitle) throws Exception;
	public abstract ArrayList<Page> findPages(String titleOrDescription) throws Exception;
	public abstract ArrayList<Post> findInfoInPublicPosts(String msg) throws Exception;
}
