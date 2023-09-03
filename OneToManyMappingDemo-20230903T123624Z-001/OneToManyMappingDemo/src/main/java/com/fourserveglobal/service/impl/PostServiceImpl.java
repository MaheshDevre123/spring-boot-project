package com.fourserveglobal.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fourserveglobal.exception.ErrorDetails;
import com.fourserveglobal.model.Comment;
import com.fourserveglobal.model.Post;
import com.fourserveglobal.repository.CommentRepository;
import com.fourserveglobal.repository.PostRepository;
import com.fourserveglobal.service.PostService;
@Service
public class PostServiceImpl implements PostService {
	@Autowired
    private PostRepository postRepository;
	@Autowired
    private CommentRepository commentRepository;
	@Override
	public Post savePost(Post post, Comment comment) {
		
		return postRepository.save(post);
	}
	@Override
	public List<Post> getAllPost() {
		
		return postRepository.findAll();
	}
	@Override
	public Post getPostById(int id) {
	
		return postRepository.findById(id).orElseThrow(() -> new ErrorDetails());
	}

	
	@Override
	public void deletePost(int id) {
		postRepository.findById(id).orElseThrow(()-> new ErrorDetails());
		postRepository.deleteById(id);
		
	}
	@Override
	public boolean isPostExist(int id) {
		Post post = new Post();
		return postRepository.existsById(id);
	}
	@Override
	public Post updatePost(Post post, int id) {
		Post post1 = new Post();
		post1.setId(id);
		post1.setTitle(post.getTitle());
		post1.setDescription(post.getDescription());
		
		List<Comment> comments= new ArrayList<>();
		for(Comment cm:post.getComment()) {
			Comment comment= new Comment();
			comment.setId(cm.getId());
			comment.setText(cm.getText());
			comments.add(comment);
		}
		post1.setComment(comments);
		return postRepository.save(post1);
	}
	
}
