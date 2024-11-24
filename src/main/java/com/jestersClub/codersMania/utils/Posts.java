package com.jestersClub.codersMania.utils;

import com.jestersClub.codersMania.utils.Category; // Adjust import as necessary
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    private String createdAt;
    private String updatedAt;
    private String author;
    private String type;
    private String sharedLink;
    private boolean draft;
    private boolean archived;

    @Enumerated(EnumType.STRING)
    private Category category;
}
