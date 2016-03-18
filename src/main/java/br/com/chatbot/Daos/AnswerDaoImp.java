package br.com.chatbot.Daos;


import br.com.chatbot.entitys.Answer;
import br.com.chatbot.entitys.Question;
import br.com.chatbot.repositories.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.core.query.TextQuery;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AnswerDaoImp implements AnswerDao {

    private AnswerRepository answerRepository;
    private MongoOperations operations;

    @Autowired
    public AnswerDaoImp(AnswerRepository answerRepository, MongoOperations operations) {
        this.answerRepository = answerRepository;
        this.operations = operations;
    }

    public Answer findByQuestionScore(Question question){
        Query query = TextQuery.queryText(new TextCriteria().matching(question.getQuestion())).sortByScore();
        return operations.findOne(query, Answer.class);
    }

    public Answer save(Answer answer){
        return answerRepository.save(answer);
    }

    public List<Answer> save(List<Answer> answers){
        return answerRepository.save(answers);
    }

    public List<Answer> findAll(){
        return answerRepository.findAll();
    }



}
