package dj.aurelia.aureliaclient.security.service;

import dj.aurelia.aureliaclient.domain.UserDto;
import dj.aurelia.aureliaclient.domain.security.Authority;
import dj.aurelia.aureliaclient.security.JwtUserFactory;
import dj.aurelia.aureliaclient.security.repository.AuthorityRepository;
import dj.aurelia.aureliaclient.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;
    @Autowired
    private AuthorityRepository authorityRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDto user = userService.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        } else {

            List<Authority> auth = new ArrayList<>();
            for (Long i : user.getAuthorities()) {
                Optional<Authority> opt = authorityRepository.findById(i);
                opt.ifPresent(auth::add);
            }
            return JwtUserFactory.create(user, auth);
        }
    }
}
