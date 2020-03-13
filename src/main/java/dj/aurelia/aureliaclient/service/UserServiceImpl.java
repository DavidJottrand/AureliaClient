package dj.aurelia.aureliaclient.service;

import dj.aurelia.aureliaclient.domain.UserDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserServiceImpl implements UserService {

    private RestTemplate restTemplate;

    public UserServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public UserDto findByUsername(String username) {
        return restTemplate.getForEntity("http://aureliauser" + "/user/username/security/" + username, UserDto.class).getBody();
    }
}
