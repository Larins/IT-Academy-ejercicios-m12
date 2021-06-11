package springBootInitialDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springBootInitialDemo.dto.UserResponseDto;
import springBootInitialDemo.service.IUserService;

@RestController
//@RequestMapping("/v1")
public class InitialController {

    private final IUserService userService;

    @Autowired
    public InitialController(IUserService userService){
        this.userService = userService;
    }



    //@PutMapping(value ="", consumes = {"application/json"})
    @GetMapping("/user/{uuid}")
    public ResponseEntity<UserResponseDto> updatePrescription(
            @PathVariable(name="uuid") String user) throws Exception {


        UserResponseDto userResponseDto = userService.getUser(user);

        System.out.println(userResponseDto.getName());
        System.out.println(userResponseDto.getSurname());
        System.out.println(userResponseDto.getGender());

        return new ResponseEntity<>(userResponseDto, HttpStatus.OK);

    }
    
    //FASE 2 HELLO WORLD
    //URL exemple: http://localhost:8080
    /*@GetMapping(value="/")
    public String helloGradle() {
        return "Hello WORLD!";
    }*/
    
    //FASE 2 ENTRAR VARIABLE PER PATH
    //URL exemple: http://localhost:8080/lara (qualsevol <NAME>)
    //URL exemple: http://localhost:8080/user/Jonatan (descarrega JSON del repositori)
    /*@GetMapping(value="/{uuid}")
    public String helloGradle(@PathVariable(name="uuid") String user) {
        return "Hello " + user + "!";
    }*/
    
    //FASE 3 LOCAL
    // ENTRAR VARIABLE PER PATH AMB URL DEL POSTMAN I MOSTRA "HELLO <NAME>" 
    //URL exemple: http://localhost:8080/localhost/lara (qualsevol <NAME>)
    @GetMapping(value="/localhost/{uuid}")
    public String helloGradle(@PathVariable(name="uuid") String user) {
        return "Hello " + user + "!";
    }
    
    //FASE 3 DESENVOLUPAMENT
    // ENTRAR VARIABLE PER PATH AMB URL DEL POSTMAN I MOSTRA "HELLO <NAME>" 
    //URL exemple: http://localhost:8080/dev.domain.com/lara (qualsevol <NAME>)
    /*@GetMapping(value="/dev.domain.com/{uuid}")
    public String helloGradle(@PathVariable(name="uuid") String user) {
        return "Hello " + user + "!";
    }*/
    
    //FASE 3 PREPRODUCCIO
    // ENTRAR VARIABLE PER PATH AMB URL DEL POSTMAN I MOSTRA "HELLO <NAME>" 
    //URL exemple: http://localhost:8080/pre.domain.com/lara (qualsevol <NAME>)
    /*@GetMapping(value="/pre.domain.com/{uuid}")
    public String helloGradle(@PathVariable(name="uuid") String user) {
        return "Hello " + user + "!";
    }*/
    
    
    
}
