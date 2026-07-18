package com.priyankabhalerao.linkedinclone.posts_service.Service;

import com.priyankabhalerao.linkedinclone.posts_service.Dtos.PostCreateRequestDto;
import com.priyankabhalerao.linkedinclone.posts_service.Dtos.PostDto;
import com.priyankabhalerao.linkedinclone.posts_service.Entity.Post;
import com.priyankabhalerao.linkedinclone.posts_service.Repository.PostsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

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
}
