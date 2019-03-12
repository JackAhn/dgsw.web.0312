package kr.hs.dgsw.web_get1;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.Optional;

@RestController
public class GetController {

    @GetMapping("/greeting")
    public String greeting(@RequestParam String say, @RequestParam(required = false, defaultValue = "NONAME") String to){
        return say + " "+  to;
    }

    @GetMapping(value={"/greeting1/{say}/{to}", "/greeting1", "/greeting1/{say}", "/greeting1//{to}"})
    public String greeting1(
            @PathVariable Optional<String> say,
            @PathVariable Optional<String> to
    ){
        String temp = say.isPresent() ? say.get() : "메롱";
        String tmp = to.isPresent() ? to.get() : "NONAME";
        return temp + " "+ tmp;
    }
}
