package dj.aurelia.aureliaclient.domain;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class AbominationDto extends MonsterDto {

    @Builder
    public AbominationDto(UUID uuid, String name, int currentHealth, int maxHealth, int currentMana, int maxMana, int attack, int defense, String imagePath, MonsterClass type) {
        super(uuid, name, currentHealth, maxHealth, currentMana, maxMana, attack, defense, imagePath, type);
    }
}
