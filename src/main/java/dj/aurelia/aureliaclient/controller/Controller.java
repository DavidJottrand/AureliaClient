package dj.aurelia.aureliaclient.controller;

import dj.aurelia.aureliaclient.domain.UserDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Controller {

    RestTemplate restTemplate;

    public Controller(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/username/{username}")
    public UserDto findUserByUsername(@PathVariable("username") String username){
        return restTemplate.getForEntity("http://aureliauser" + "/user/username/" + username, UserDto.class).getBody();
    }
}
