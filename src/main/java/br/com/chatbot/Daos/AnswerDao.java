package br.com.chatbot.Daos;


import br.com.chatbot.entitys.Answer;
import br.com.chatbot.entitys.Question;

import java.util.List;

public interface AnswerDao {

    public Answer save(Answer answer);
    public List<Answer> save(List<Answer> answers);
    public List<Answer> findAll();
    public Answer findByQuestionScore(Question question);

}
