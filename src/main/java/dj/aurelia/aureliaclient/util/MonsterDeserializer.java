package dj.aurelia.aureliaclient.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import dj.aurelia.aureliaclient.domain.AbominationDto;
import dj.aurelia.aureliaclient.domain.BoarDto;
import dj.aurelia.aureliaclient.domain.MonsterClass;
import dj.aurelia.aureliaclient.domain.MonsterDto;
import dj.aurelia.aureliaclient.handlerexceptions.MonsterTypeException;


import java.io.IOException;
import java.util.UUID;

public class MonsterDeserializer extends StdDeserializer<MonsterDto> {

    public MonsterDeserializer() {
        this(null);
    }

    public MonsterDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public MonsterDto deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        JsonNode node = jp.getCodec().readTree(jp);
        UUID uuid;
        String name;
        int currentHealth;
        int maxHealth;
        int currentMana;
        int maxMana;
        int attack;
        int defense;
        String imagePath;
        MonsterClass type;
        MonsterDto monsterDto = null;

        uuid = UUID.fromString(node.get("uuid").asText());
        name = node.get("name").asText();
        currentHealth = node.get("currentHealth").asInt();
        maxHealth = node.get("maxHealth").asInt();
        currentMana = node.get("currentMana").asInt();
        maxMana = node.get("maxMana").asInt();
        attack = node.get("attack").asInt();
        defense = node.get("defense").asInt();
        imagePath = node.get("imagePath").asText();
        String typeString = node.get("type").asText();

        switch (typeString){
            case "BOAR":
                type = MonsterClass.BOAR;
                monsterDto = BoarDto.builder()
                        .uuid(uuid)
                        .name(name)
                        .currentHealth(currentHealth)
                        .maxHealth(maxHealth)
                        .currentMana(currentMana)
                        .maxMana(maxMana)
                        .attack(attack)
                        .defense(defense)
                        .imagePath(imagePath)
                        .type(type)
                        .build();
                break;
            case "ABOMINATION":
                type = MonsterClass.ABOMINATION;
                monsterDto = AbominationDto.builder()
                        .uuid(uuid)
                        .name(name)
                        .currentHealth(currentHealth)
                        .maxHealth(maxHealth)
                        .currentMana(currentMana)
                        .maxMana(maxMana)
                        .attack(attack)
                        .defense(defense)
                        .imagePath(imagePath)
                        .type(type)
                        .build();
                break;
            default:
                throw new MonsterTypeException("MonsterDeserializer : Monster type not available.");
        }

        return monsterDto;
    }
}
