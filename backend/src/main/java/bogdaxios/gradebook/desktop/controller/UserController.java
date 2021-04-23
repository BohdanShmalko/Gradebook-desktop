package bogdaxios.gradebook.desktop.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @PostMapping("/createUser")
    public ResponseEntity createUser() {
        try {
            return ResponseEntity.ok("All work");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body("Error in server");
        }
    }

    @GetMapping("/getUser")
    public ResponseEntity getUser() {
        try {
            return ResponseEntity.ok("All work");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error in server");
        }
    }

    @PostMapping("/information")
    public ResponseEntity createInf() {
        try {
            return ResponseEntity.ok("All work");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error in server");
        }
    }
}
