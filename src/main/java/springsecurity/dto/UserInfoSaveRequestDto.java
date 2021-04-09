package springsecurity.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import springsecurity.domain.UserInfo;

@Getter
@Setter
public class UserInfoSaveRequestDto {
    private String email;
    private String password;
    private String auth;

    @Builder
    public UserInfoSaveRequestDto (String email, String password, String auth ){
        this.email = email;
        this.password = password;
        this.auth = auth;
    }

    public UserInfo ToEntity() {
        return UserInfo.builder()
                .email(email)
                .password(password)
                .auth(auth)
                .build();
    }


}
