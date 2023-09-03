package com.fourserveglobal.service;

import java.util.List;
import java.util.Optional;

import com.fourserveglobal.model.Comment;
import com.fourserveglobal.model.Post;

public interface PostService {
    public  Post savePost(Post post, Comment comment);
    public List<Post> getAllPost();
    public Post getPostById(int id);
    public Post updatePost(Post post, int id);
    public void deletePost(int id); 
	public boolean isPostExist(int id);
	 
     
}
