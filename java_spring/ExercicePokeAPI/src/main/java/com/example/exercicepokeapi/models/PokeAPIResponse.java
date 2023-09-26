package com.example.exercicepokeapi.models;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PokeAPIResponse {

    @Data
    @Builder
    public static class AbilitySummary {
        private Integer slot;
        private Boolean is_hidden;
        private Ability ability;
    }

    @Data
    @Builder
    public static class Ability {
        private String name;
        private String url;
    }

    @Data
    @Builder
    public static class TypeSummary {
        private Integer slot;
        private Type type;
    }

    @Data
    @Builder
    public static class Type {
        private String name;
        private String url;
    }



    private Integer id;
    private String formattedId;
    private String name;
    private Integer height;
    private Integer weight;
    private List<AbilitySummary> abilities;
    private List<TypeSummary> types;

}
