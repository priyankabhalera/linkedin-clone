package com.priyankabhalerao.linkedinclone.posts_service.Controller;

import com.priyankabhalerao.linkedinclone.posts_service.Dtos.PostCreateRequestDto;
import com.priyankabhalerao.linkedinclone.posts_service.Dtos.PostDto;
import com.priyankabhalerao.linkedinclone.posts_service.Entity.Post;
import com.priyankabhalerao.linkedinclone.posts_service.Service.PostsService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.micrometer.observation.autoconfigure.ObservationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostsService postsService;

    public PostController(PostsService postsService) {
        this.postsService = postsService;
    }

    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostCreateRequestDto postDto, HttpServletRequest httpServletRequest)
    {
        PostDto createPost = postsService.createPost(postDto,2L);
        return new ResponseEntity<>(createPost, HttpStatus.CREATED);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostDto> getPostById(@PathVariable Long postId)
    {
        PostDto postDto = postsService.getPost(postId);
        return ResponseEntity.ok(postDto);
    }

//    @GetMapping("/fetch")
//    public ResponseEntity<List<PostDto>> getPosts()
//    {
//        List<PostDto> allPosts = postsService.getAllPosts();
//        return  new ResponseEntity<>(allPosts,HttpStatus.OK);
//    }
}
