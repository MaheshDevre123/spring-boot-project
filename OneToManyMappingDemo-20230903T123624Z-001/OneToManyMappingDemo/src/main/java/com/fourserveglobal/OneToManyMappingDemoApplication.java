package com.fourserveglobal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fourserveglobal.model.Comment;
import com.fourserveglobal.model.Post;
import com.fourserveglobal.repository.CommentRepository;
import com.fourserveglobal.repository.PostRepository;

@SpringBootApplication
public class OneToManyMappingDemoApplication /* implements CommandLineRunner */{

	public static void main(String[] args) {
		SpringApplication.run(OneToManyMappingDemoApplication.class, args);
	}

	/*
	 * @Autowired private PostRepository postRepository;
	 * 
	 * @Autowired private CommentRepository commentRepository;
	 * 
	 * @Override public void run(String... args) throws Exception { //Post object
	 * Post post = new Post("Today is my Birthday", "Wish me Happy Birthday");
	 * 
	 * //Comment object Comment comment1 = new Comment("Happy Birthday"); Comment
	 * comment2 = new Comment("Many Many Happy returns of the day"); Comment
	 * comment3 = new Comment("Gob bless Yoy"); Comment comment4 = new
	 * Comment("Happy Birthday, Have a Good Day");
	 * 
	 * post.getComment().add(comment1); post.getComment().add(comment2);
	 * post.getComment().add(comment3); post.getComment().add(comment4);
	 * 
	 * this.postRepository.save(post); }
	 */

}
