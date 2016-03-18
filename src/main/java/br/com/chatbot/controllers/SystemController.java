package br.com.chatbot.controllers;

import br.com.chatbot.entitys.Answer;
import br.com.chatbot.services.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class SystemController {

    @Autowired private AnswerService answerService;

    @RequestMapping(value = "/pop",method = RequestMethod.GET)
    public HttpEntity<List<Answer>> populate(){
        List<Answer> answers = answerService.findAll();
        if(answers.size() > 0){
            return new ResponseEntity<List<Answer>>(answers, HttpStatus.OK);
        }

        answers = Arrays.asList(
                new Answer(null,Arrays.asList("ola","hello"),"Olá %s, como vai? Vamos falar sobre seu carro!"),
                new Answer(null,Arrays.asList("carro","som","mp3","pen drive"),"Para adicionar musicas mp3 através de um pen drive faça..."),
                new Answer(null,Arrays.asList("carro","motor","oleo","troca de oleo","revisão"),"Para efetuar a troca de oleo do carro sugerimos a revisão..."),
                new Answer(null,Arrays.asList("carro","som","bluetooth","sincronização","celular","smarthphone"),"Para sincronizar seu celular pelo bluetooth...")
        );

        answers = answerService.save(answers);

        return new ResponseEntity<List<Answer>>(answers, HttpStatus.OK);
    }

}
