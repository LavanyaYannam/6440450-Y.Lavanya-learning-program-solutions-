package HandsOn4;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (!username.equals("user")) {
            throw new UsernameNotFoundException("User not found");
        }

        // username: user, password: pwd, role: USER
        return User.withUsername("user")
                .password("pwd")
                .roles("USER")
                .build();
    }
}
