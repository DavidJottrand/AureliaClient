package dj.aurelia.aureliaclient.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import dj.aurelia.aureliaclient.util.MonsterDeserializer;
import lombok.*;

import java.util.UUID;

@JsonDeserialize(using = MonsterDeserializer.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public abstract class MonsterDto {
    // ======================
    // ===== Attributes =====
    // ======================

    protected UUID uuid;
    protected String name;
    protected int currentHealth;
    protected int maxHealth;
    protected int currentMana;
    protected int maxMana;
    protected int attack;
    protected int defense;
    private String imagePath;
    private MonsterClass type;



    // ===================
    // ===== Methods =====
    // ===================

    @Override
    public String toString() {
        return "Monster{" +
                "uuid=" + this.getUuid()+
                ", name='" + this.getName() + '\'' +
                ", currentHealth=" + this.getCurrentHealth() +
                ", maxHealth=" + this.getMaxHealth() +
                ", currentMana=" + this.getCurrentMana() +
                ", maxMana=" + this.getMaxMana() +
                ", attack=" + this.getAttack() +
                ", defense=" + this.getDefense() +
                ", imagePath=" + this.getImagePath() +
                ", type=" + this.getType() +
                '}';
    }
}
