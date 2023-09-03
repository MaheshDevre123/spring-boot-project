
package com.fourserveglobal.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fourserveglobal.exception.ErrorDetails;
import com.fourserveglobal.model.Comment;
import com.fourserveglobal.model.Post;
import com.fourserveglobal.repository.CommentRepository;
import com.fourserveglobal.repository.PostRepository;
import com.fourserveglobal.service.PostService;

@RestController
public class PostController {
    @Autowired
	private PostService postService;
    
   

	public PostController(PostService postService) {
		super();
		this.postService = postService;
	}
    
	@PostMapping("/post")
	public Post save(@RequestBody Post post, Comment comment) {
    	return postService.savePost(post, comment);
    }
	
	  
    // for fetching
    @GetMapping("/all")
    public List<Post> getAll() {
    	return postService.getAllPost();
    }
    
    // for fetching by id
    @GetMapping("{id}")
    public ResponseEntity<Post> getPostById( @PathVariable int id)
    {
    	
    	boolean isPostExist=postService.isPostExist(id);
    	if(isPostExist) {
    	return new ResponseEntity<Post>(postService.getPostById(id), HttpStatus.OK);
    	}
    	else {
    	throw new ErrorDetails("User is not available  : "+id);
    	}
    }
    
    
    @PutMapping("/{id}")
    public ResponseEntity<Post> update(@PathVariable Integer id, @RequestBody Post post) {
    	boolean isPostExist=postService.isPostExist(id);
        if (isPostExist) {
            return  new ResponseEntity<Post>(postService.updatePost(post, id),HttpStatus.OK);
            		
        }
        else {
        	  throw new ErrorDetails("User is not available  : "+id);
        }

       
		/*
		 * postService.updatePost(post,id);
		 * 
		 * return ResponseEntity.noContent().build();
		 */
    }
    
    //for delete
    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePost(@PathVariable("id") int id){
    	//delete employee from DB
    	boolean isPostExist=postService.isPostExist(id);
    	if(isPostExist) {
    	postService.deletePost(id);
    	return new ResponseEntity<String>("Post Deleted successfully ", HttpStatus.OK);
    	}else
    	{
    		throw new ErrorDetails("Employee is not available : "+id);
    	}
    }
}
