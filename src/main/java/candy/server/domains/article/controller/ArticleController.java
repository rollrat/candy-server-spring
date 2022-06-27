package candy.server.domains.article.controller;

import candy.server.config.auth.LoginUser;
import candy.server.config.auth.SessionUser;
import candy.server.domains.article.dto.ArticleDto;
import candy.server.domains.article.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @PostMapping("/article/write")
    @ResponseBody
    public ArticleDto.ArticleWriteResponse articleWrite(@LoginUser SessionUser user,
                                                        @RequestBody ArticleDto.ArticleWriteRequest dto) {
        return ArticleDto.ArticleWriteResponse.builder()
                .articleId(articleService.articleWrite(user, dto))
                .build();
    }

    @GetMapping("/article/read")
    @ResponseBody
    public ArticleDto.ArticleReadResponse articleRead(@LoginUser SessionUser user,
                                                      @RequestParam Long id) {
        return articleService.articleRead(user, id);
    }

    @GetMapping("/admin/article/read")
    @Secured("hasRole('ROLE_ADMIN')")
    public ArticleDto.ArticleWriteResponse adminArticleRead(@LoginUser SessionUser user,
                                                            @RequestBody Long dto) {
        return null;
    }


    @GetMapping("/article/recent")
    @ResponseBody
    /* get recent articles regardless of boardKey */
    public ArticleDto.ArticleRecentResponse articleRecent(@RequestParam int p) {
        return articleService.articleRecent(p);
    }
}
