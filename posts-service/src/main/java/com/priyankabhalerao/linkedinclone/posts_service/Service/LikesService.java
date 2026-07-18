package com.priyankabhalerao.linkedinclone.posts_service.Service;

import com.priyankabhalerao.linkedinclone.posts_service.Entity.PostLike;
import com.priyankabhalerao.linkedinclone.posts_service.Exception.ResourceNotFoundException;
import com.priyankabhalerao.linkedinclone.posts_service.Repository.LikesRepository;
import com.priyankabhalerao.linkedinclone.posts_service.Repository.PostsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LikesService {
    private final LikesRepository likesRepository;
    private final PostsRepository postsRepository;


    public LikesService(LikesRepository likesRepository, PostsRepository postsRepository) {
        this.likesRepository = likesRepository;
        this.postsRepository = postsRepository;
    }

    public void likesPost(Long postId, Long userId)
    {
        log.info("Attempting to like post with Id "+postId);
        boolean exists = postsRepository.existsById(postId);

        if(!exists) throw new ResourceNotFoundException("Post not found with this Id "+postId);

        boolean alreadyLiked = likesRepository.existsByPostIdAndUserId(postId,userId);

        if(alreadyLiked) throw new RuntimeException("Cannot Like Same Post again");

        PostLike postLike = new PostLike();
        postLike.setPostId(postId);
        postLike.setUserId(userId);

        likesRepository.save(postLike);
        log.info("Post with Id " + postId + " Liked Successfully");

    }
}
