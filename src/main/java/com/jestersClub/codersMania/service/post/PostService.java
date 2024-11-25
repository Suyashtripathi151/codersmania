package com.jestersClub.codersMania.service.post;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jestersClub.codersMania.entity.Questions;
import com.jestersClub.codersMania.repositories.QuestionRepository;
import com.jestersClub.codersMania.utils.Option;
import com.jestersClub.codersMania.utils.Options;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private ObjectMapper objectMapper;

    public void createQuestion(Questions question) throws Exception {
        // Validate options JSON format
        if (isValidOptionsStructure(question.getOptions()) == false) {
            System.out.println("yeeeeeeeeeeeeeeeeeeeee");
            throw new IllegalArgumentException("Options structure is invalid.");

        }
        else {
            System.out.println("nooooooooooooo");
        }

        questionRepository.save(question);
    }

    private boolean isValidOptionsStructure(String optionsJson) {
        try {
            objectMapper.readValue(optionsJson, Options.class);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
