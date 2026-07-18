package com.priyankabhalerao.linkedinclone.posts_service.Repository;

import com.priyankabhalerao.linkedinclone.posts_service.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostsRepository extends JpaRepository<Post, Long> {
}
