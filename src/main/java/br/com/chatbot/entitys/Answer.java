package br.com.chatbot.entitys;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "answers")
public class Answer {


    @Id private String id;
    @TextIndexed private List<String> tags;
    private String responseMessage;
    private double score;

    public Answer(String id, List<String> tags, String responseMessage) {
        this.id = id;
        this.tags = tags;
        this.responseMessage = responseMessage;
    }

    public Answer(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public double getScore() {
        return score;
    }

}
