package springsecurity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import springsecurity.dto.UserInfoSaveRequestDto;
import springsecurity.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/user")
    public String signup( UserInfoSaveRequestDto userInfoSaveRequestDto ){
        userService.save( userInfoSaveRequestDto );
        return "redirect:/login";
    }

    @GetMapping( value = "/logout" )
    public String logoutPage( HttpServletRequest request, HttpServletResponse response ){
        new SecurityContextLogoutHandler().logout(
                request, response, SecurityContextHolder.getContext().getAuthentication()
            );
        return "redirect:/logout";
    }

}
