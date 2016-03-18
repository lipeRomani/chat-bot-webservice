package br.com.chatbot.repositories;


import br.com.chatbot.entitys.Answer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.ArrayList;
import java.util.List;

public interface AnswerRepository extends MongoRepository<Answer,String> {

    @Override
    Answer save(Answer answer);

    @Override
    List<Answer> findAll();
}
