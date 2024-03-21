package service;

public interface IUserService {
	
	public abstract boolean login(String username, String password);
	public abstract boolean followPage(String username, String pageTitle);

}
