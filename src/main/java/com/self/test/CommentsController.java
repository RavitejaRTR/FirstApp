package com.self.test;

import java.util.List;
import java.util.Optional;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CommentsController {
	
	RestTemplate restTemplate = new RestTemplate();
	
	@RequestMapping("/comments")
	public @ResponseBody List<Comment> getComments(@RequestParam("postId") Optional<String> postId) {
		ResponseEntity<List<Comment>> responseComments;
		String url = "https://jsonplaceholder.typicode.com/comments";
		if(postId.isPresent())
			url = url+"?postId="+postId.get();
		
		responseComments = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Comment>>() {});
		List<Comment> comments = responseComments.getBody();
		return comments;
	}
	
	@RequestMapping("/posts/{id}/comments")
	public List<Comment> getPostComments(@PathVariable("id") String id) {
		System.out.println("Here : "+id);
		String url = "https://jsonplaceholder.typicode.com/posts";
		url = url+"/"+id+"/comments";
		ResponseEntity<List<Comment>> responsePosts = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Comment>>() {});
		List<Comment> comments = responsePosts.getBody();
		return comments;
	}
	
	
	
}
