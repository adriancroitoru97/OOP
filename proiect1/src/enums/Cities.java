package enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Cities {

    @JsonProperty("Bucuresti")
    BUCURESTI("Bucuresti"),

    @JsonProperty("Constanta")
    CONSTANTA("Constanta"),

    @JsonProperty("Buzau")
    BUZAU("Buzau"),

    @JsonProperty("Timisoara")
    TIMISOARA("Timisoara"),

    @JsonProperty("Iasi")
    IASI("Iasi"),

    @JsonProperty("Oradea")
    ORADEA("Oradea"),

    @JsonProperty("Craiova")
    CRAIOVA("Craiova"),

    @JsonProperty("Braila")
    BRAILA("Braila"),

    @JsonProperty("Brasov")
    BRASOV("Brasov"),

    @JsonProperty("Cluj-Napoca")
    CLUJ_NAPOCA("Cluj-Napoca");


    private final String value;

    Cities(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
