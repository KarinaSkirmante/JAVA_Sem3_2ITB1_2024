package service;

import model.Post;
import model.PostType;

public interface IPostService {
	public abstract Post publishPost(PostType type, String msg) throws Exception;
}
