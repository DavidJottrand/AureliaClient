package dj.aurelia.aureliaclient.service;

import dj.aurelia.aureliaclient.domain.UserDto;

public interface UserService {

    UserDto findByUsername(String username);

}
