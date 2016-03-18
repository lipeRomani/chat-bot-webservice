package br.com.chatbot.controllers;


import br.com.chatbot.Daos.AnswerDao;
import br.com.chatbot.entitys.Answer;
import br.com.chatbot.entitys.Question;
import br.com.chatbot.entitys.Response;
import br.com.chatbot.services.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @RequestMapping(value = "/answer",method = RequestMethod.GET)
    public HttpEntity<Response> question(@RequestParam(value = "question" , required = false , defaultValue = "hello") Question question){
        Response response = answerService.findByQuestion(question);
        response.add(linkTo(methodOn(AnswerController.class).question(question)).withSelfRel());
        return new ResponseEntity<Response>(response,HttpStatus.OK);
    }

}
