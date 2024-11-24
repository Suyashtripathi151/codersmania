package com.jestersClub.codersMania.entity;

import com.jestersClub.codersMania.utils.Posts;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

    @Data
    @Entity
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Table(name = "Questions")
    public class Questions extends Posts {
        @Column
        private String question;

        @Id
        private String id;

        @Column(columnDefinition = "TEXT") // Store as a JSON string
        private String options;
    }


