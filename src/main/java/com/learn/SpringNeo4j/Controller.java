
package com.learn.SpringNeo4j;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController 
@CrossOrigin
public class Controller {
    
    @GetMapping("/")
    public
    ModelAndView  addNode(){//@RequestBody Node node
        
        try (Neo4jService greeter = new Neo4jService("bolt://neo4j:7687", "neo4j", "password")) {
            greeter.printGreeting("hello, world");
        }
        
        Node node=new Node(1,"str","str1","str2");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("node", node);
        return modelAndView;
    }
    @GetMapping("/hello")
    // Easy method just to print encouraging and consoling
    // words
    public String hello()
    {
        
        return "Hello Geek, this is a simple hello message to take care and have a nice day.";
    }
}












