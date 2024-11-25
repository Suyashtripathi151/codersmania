package com.jestersClub.codersMania.repositories;

import com.jestersClub.codersMania.entity.Questions;
import com.jestersClub.codersMania.entity.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Questions, Long> {
    VerificationToken findById(String id);
}
