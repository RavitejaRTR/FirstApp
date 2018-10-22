package com.self.test;

import java.util.List;
import java.util.Optional;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class PostController {

	RestTemplate restTemplate = new RestTemplate();

	@RequestMapping("/")
	public String hello() {
		return "index";
	}

	@RequestMapping("/posts")
	public List<Post> getPosts(@RequestParam("userId") Optional<String> userId) {
		String url = "https://jsonplaceholder.typicode.com/posts";
		if(userId.isPresent())
			url = url+"?userId="+userId.get();
		ResponseEntity<List<Post>> responsePosts = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Post>>() {});
		List<Post> posts = responsePosts.getBody();
		return posts;
	}
	
	@RequestMapping("/posts/{id}")
	public Post getPost(@PathVariable("id") String id) {
		System.out.println("Here : "+id);
		String url = "https://jsonplaceholder.typicode.com/posts";
		url = url+"/"+id;
		ResponseEntity<Post> responsePosts = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<Post>() {});
		Post post = responsePosts.getBody();
		return post;
	}

}
