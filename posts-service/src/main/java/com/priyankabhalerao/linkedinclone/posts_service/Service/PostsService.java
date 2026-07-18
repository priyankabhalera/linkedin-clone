package com.priyankabhalerao.linkedinclone.posts_service.Service;

import com.priyankabhalerao.linkedinclone.posts_service.Dtos.PostCreateRequestDto;
import com.priyankabhalerao.linkedinclone.posts_service.Dtos.PostDto;
import com.priyankabhalerao.linkedinclone.posts_service.Entity.Post;
import com.priyankabhalerao.linkedinclone.posts_service.Exception.ResourceNotFoundException;
import com.priyankabhalerao.linkedinclone.posts_service.Repository.PostsRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j

public class PostsService {
    private final PostsRepository postsRepository;
    private final ModelMapper modelMapper;

    public PostsService(PostsRepository postsRepository, ModelMapper modelMapperl) {
        this.postsRepository = postsRepository;
        this.modelMapper = modelMapperl;
    }

    public PostDto createPost(PostCreateRequestDto postDto, Long userId) {
        Post post = modelMapper.map(postDto,Post.class);
        post.setUserId(userId);

        Post savePost = postsRepository.save(post);
        return modelMapper.map(savePost,PostDto.class);
    }

//    public List<PostDto> getAllPosts() {
//        List<Post> allPosts = postsRepository.findAll();
//        return modelMapper.map(allPosts,PostDto.class);
//    }

    public PostDto getPost(Long postId) {
        log.debug("Retriving post with ID: {}",postId);

        Post post = postsRepository.findById(postId).orElseThrow(()->
                new ResourceNotFoundException("Post not found with Id: "+postId ));
        return modelMapper.map(post,PostDto.class);
    }
}
