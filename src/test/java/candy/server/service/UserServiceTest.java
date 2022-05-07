package candy.server.service;

import candy.server.dto.UserDto;
import candy.server.model.CaUserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@SpringBootTest
@Transactional
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void 유저_회원가입_성공() {
        UserDto.Insert insert = UserDto.Insert
                .builder()
                .id("testid")
                .pw("testpw")
                .nickname("testnickname")
                .build();

        userService.join(insert);
    }

    @Test
    void 유저_회원가입_실패() {
        UserDto.Insert insert = UserDto.Insert
                .builder()
                .id("testid")
                .pw("testpw")
                .nickname("testnickname")
                .build();

        userService.join(insert);
        assertThatIllegalArgumentException().isThrownBy(() -> userService.join(insert));
    }
}
