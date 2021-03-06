package dj.aurelia.aureliaclient.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private UUID uuid;
    private String username;
    private String password;
    private String email;
    private Boolean enabled;
    private Date lastPasswordResetDate;
    private List<UUID> characters;
    private List<Long> authorities;

}
