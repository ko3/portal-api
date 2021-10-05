package com.monka.potal.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.monka.potal.api.model.Blog;

@RestController
public class BlogsController {
	
	@GetMapping("/blogs")
	public List<Blog> getBlogs(){
		List<Blog> blogs = new ArrayList<>();
		
		
		return blogs;
	}
	
	@GetMapping("/blogs/{blogId}")
	public Blog getBlog(@PathVariable String blogId){
		Blog blog = new Blog();
		
		
		return blog;
	}
	
	@PostMapping("/blogs/blogs")
	public Blog createBlog(@RequestBody Blog blog){
		
		
		return blog;
	}
	
	@PutMapping("/blogs/{blogId}")
	public Blog updateBlog(@PathVariable String blogId, @RequestBody Blog blog){
		
		
		return blog;
	}
	
	@DeleteMapping("/blogs/{blogId}")
	public Blog deleteBlog(@PathVariable String blogId){
		Blog blog = new Blog();
		return blog;
	}

}
