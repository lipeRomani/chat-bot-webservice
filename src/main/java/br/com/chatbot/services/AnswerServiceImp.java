package br.com.chatbot.services;

import br.com.chatbot.Daos.AnswerDao;
import br.com.chatbot.entitys.Answer;
import br.com.chatbot.entitys.Question;
import br.com.chatbot.entitys.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerServiceImp implements AnswerService {

    private AnswerDao answerDao;

    @Autowired
    public AnswerServiceImp(AnswerDao answerDao) {
        this.answerDao = answerDao;
    }

    public Answer save(Answer answer){
        return answerDao.save(answer);
    }
    public List<Answer> save(List<Answer> answers){
        return answerDao.save(answers);
    }


    public List<Answer> findAll(){
        return answerDao.findAll();
    }

    @Override
    public Response findByQuestion(Question question) {
        Answer answer = answerDao.findByQuestionScore(question);
        return getResponseFrom(answer, question);
    }

    private Response getResponseFrom(Answer answer, Question question) {
        if(answer == null)
           return new Response("Infelizmente não sabemos muito desse assunto ainda!",question);
        return new Response(answer.getResponseMessage(),question);
    }
}
