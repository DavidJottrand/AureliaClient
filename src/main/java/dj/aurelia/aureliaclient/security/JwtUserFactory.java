package dj.aurelia.aureliaclient.security;

import dj.aurelia.aureliaclient.domain.UserDto;
import dj.aurelia.aureliaclient.domain.security.Authority;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public final class JwtUserFactory {


    private JwtUserFactory() {}



    public static JwtUser create(UserDto user, List<Authority> auth) {

        return new JwtUser(
                user.getUuid(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                mapToGrantedAuthorities(auth),
                user.getEnabled(),
                user.getLastPasswordResetDate()
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<Authority> authorities) {
        return authorities.stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getName().name()))
                .collect(Collectors.toList());
    }
}
