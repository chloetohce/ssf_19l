package sg.edu.nus.iss.ssf_19l.controller;

import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class DemoController {
    @GetMapping("/health")
    public ModelAndView getHealth() {
        ModelAndView mav = new ModelAndView();
        try {
            checkHealth();

            mav.setViewName("healthy");
            mav.setStatus(HttpStatus.OK);
        } catch (Exception e) {
            mav.setViewName("unhealthy");
            mav.setStatus(HttpStatusCode.valueOf(400));
        } 
        return mav;
    }
    
    private void checkHealth() throws Exception {
        int random = new Random().nextInt(10);

        if (random < 3) {
            throw new Exception();
        }
    }
    
}
