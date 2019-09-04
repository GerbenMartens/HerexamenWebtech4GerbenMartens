package edu.ap.spring.eightball.Controller;

import java.io.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RedisController {

    List<String> eightBAllAnswers = Arrays.asList("It is certain.","It is decidedly so.", "Without a doubt.", "Yes - definitely.", "You may rely on it.", "As I see it, yes.",
    "Most likely.", "Outlook good.", "Yes.", "Signs point to yes.", "Reply hazy, try again.", "Ask again later.", "Better not tell you now.", 
    "Cannot predict now.", "Concentrate and ask again.", "Don't count on it.", "My reply is no.", "My sources say no.", "Outlook not so good.", 
    "Very doubtful.");
     
   @GetMapping("/index")
   public String index(Model model) {
       int random = generateRandom();
       String randomText = eightBAllAnswers.get(random);
	   
	   return randomText;
   }

    public int generateRandom(){
        Random r = new Random();
        return r.nextInt(19);
    }
}
