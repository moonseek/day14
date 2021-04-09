package springsecurity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import springsecurity.domain.UserInfo;
import springsecurity.dto.UserInfoSaveRequestDto;
import springsecurity.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    // repository 는 save method 제공 = insert, update

    public Long save( UserInfoSaveRequestDto userInfoSaveRequestDto ){

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        userInfoSaveRequestDto.setPassword( encoder.encode( userInfoSaveRequestDto.getPassword()));

        return userRepository.save(
            userInfoSaveRequestDto.ToEntity()).getCode();

    }
    @Override
    public UserInfo loadUserByUsername( String email ){
        return userRepository.findByEmail(email).orElseThrow(
                () -> new UsernameNotFoundException((email))
        );
    }

}
