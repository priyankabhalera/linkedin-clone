package com.priyankabhalerao.linkedinclone.posts_service.Controller;

import com.priyankabhalerao.linkedinclone.posts_service.Service.LikesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/likes")
public class LikesController {

    private final LikesService likesService;

    public LikesController(LikesService likesService) {
        this.likesService = likesService;
    }

    @PostMapping("/{postId}")
    public ResponseEntity<Void> likesPost(@PathVariable Long postId)
    {
        likesService.likesPost(postId,1L);
        return ResponseEntity.noContent().build();
    }
}
