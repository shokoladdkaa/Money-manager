package me.golovata.balance.integration.mono;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum CardType {
    @JsonProperty("black")
    BLACK("black"),

    @JsonProperty("white")
    WHITE("white"),

    @JsonProperty("platinum")
    PLATINUM("platinum"),

    @JsonProperty("iron")
    IRON("iron"),

    @JsonProperty("fop")
    FOP("fop"),

    @JsonProperty("yellow")
    YELLOW("yellow"),

    @JsonProperty("eAid")
    EAID("eAid");

    private final String type;

    CardType(String type) {
        this.type = type;
    }
}
