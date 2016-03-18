package br.com.chatbot.entitys;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.hateoas.ResourceSupport;


public class Response extends ResourceSupport{

    private String message;
    private Question question;

    public Response(String message, Question question) {

        this.message = message;
        this.question = question;
    }

    public Response(){}

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
