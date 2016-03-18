package br.com.chatbot.entitys;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.hateoas.ResourceSupport;

import java.time.LocalDateTime;

public class Question extends ResourceSupport {

    private String question;

    @JsonCreator
    public Question(
            @JsonProperty("question") String question) {

        this.question = question;
    }

    public Question(){}



    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
