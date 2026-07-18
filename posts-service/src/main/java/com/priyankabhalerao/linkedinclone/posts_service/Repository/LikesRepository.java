package com.priyankabhalerao.linkedinclone.posts_service.Repository;

import com.priyankabhalerao.linkedinclone.posts_service.Entity.PostLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikesRepository extends JpaRepository<PostLike,Long> {
    public boolean existsByPostIdAndUserId(Long postId,Long userId);
}
