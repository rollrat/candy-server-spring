package candy.server.domains.bookmark.repository;

import candy.server.domains.article.dao.JpaArticleRepository;
import candy.server.domains.article.entity.CaArticleEntity;
import candy.server.domains.bookmark.entity.CaArticleBookmarkEntity;
import candy.server.domains.user.dao.JpaUserRepository;
import candy.server.domains.user.entity.CaUserEntity;
import candy.server.domains.user.entity.UserRoleEnum;
import net.bytebuddy.asm.Advice;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@Transactional
public class JpaArticleBookmarkRepositoryTest {

    @Autowired
    private JpaArticleBookmarkRepository articleBookmarkRepository;
    @Autowired
    private JpaUserRepository userRepository;
    @Autowired
    private JpaArticleRepository articleRepository;

    private CaUserEntity targetUser;
    private CaArticleEntity targetArticle;

    @BeforeEach
    void beforeEach() {
        targetUser = CaUserEntity.UserBuilder()
                .userRole(UserRoleEnum.GUEST)
                .build();
        userRepository.saveAndFlush(targetUser);
        targetArticle = CaArticleEntity.builder().build();
        articleRepository.saveAndFlush(targetArticle);
    }

    @Test
    void findByUserId() {
        articleBookmarkRepository.save(CaArticleBookmarkEntity.builder()
                        .articleId(targetArticle)
                        .userId(targetUser)
                .build());

        Optional<List<CaArticleBookmarkEntity>> bookmarks = articleBookmarkRepository.findByUserId(targetUser);
        Assertions.assertThat(bookmarks.isPresent()).isTrue();
        Assertions.assertThat(bookmarks.get().size()).isEqualTo(1);
    }
}
