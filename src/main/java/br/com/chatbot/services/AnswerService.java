package br.com.chatbot.services;

import br.com.chatbot.entitys.Answer;
import br.com.chatbot.entitys.Question;
import br.com.chatbot.entitys.Response;

import java.util.List;

public interface AnswerService {

    public Answer save(Answer answer);
    public List<Answer> save(List<Answer> answers);
    public List<Answer> findAll();
    public Response findByQuestion(Question question);
}
