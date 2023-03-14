package com.example.demo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {
    public static void main(String[] args) {
      SpringApplication.run(DemoApplication.class, args);
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "message", defaultValue = "World") String message, @RequestParam(value = "user", defaultValue = "Juan") String user) {
      return String.format("%s by %s!", message, user);
    }

    @PostMapping("/postbody")
    public ResponseEntity postBody(@RequestBody String fullName) {
        return new ResponseEntity(fullName,null,HttpStatus.OK);
    }
}