package candy.server.controller;

import candy.server.dto.UserDto;
import candy.server.model.CaUserEntity;
import candy.server.service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
import java.util.List;

@RequiredArgsConstructor
@Controller
@Slf4j
public class UserController {
    private final UserService userService;

    @GetMapping("/user/all")
    @ResponseBody
    public List<CaUserEntity> userAll() {
        return userService.findAll();
    }

    @PostMapping("/user/signup")
    public String userSignup(@RequestParam UserDto.Signup dto) {
        userService.join(dto);
        log.info("/user/signup!");
        return "redirect:/";
    }

    @PostMapping("/user/login")
    public String userLogin(@RequestParam UserDto.Login dto) {
        log.info("try login ");
        return "redirect:/";
    }

}
