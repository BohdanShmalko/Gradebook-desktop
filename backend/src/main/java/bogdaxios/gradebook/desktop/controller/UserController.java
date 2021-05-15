package bogdaxios.gradebook.desktop.controller;

import bogdaxios.gradebook.desktop.entity.Auths;
import bogdaxios.gradebook.desktop.exeptions.UserAlreadyExist;
import bogdaxios.gradebook.desktop.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private AuthService authService;

    @PostMapping("/registration/student")
    public ResponseEntity createStudent(@RequestBody Auths auth) {
        try {
            authService.registration(auth);
            return ResponseEntity.ok("All work");
        } catch (UserAlreadyExist e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error in server");
        }
    }

    @PostMapping("/registration/admin")
    public ResponseEntity createAdmin(@RequestBody Auths auth) {
        try {
            authService.registration(auth);
            return ResponseEntity.ok("All work");
        } catch (UserAlreadyExist e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error in server");
        }
    }

    @PostMapping("/create/teacher")
    public ResponseEntity createTeacher(@RequestBody Auths auth) {
        try {
            return ResponseEntity.ok("All work");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body("Error in server");
        }
    }

    @PostMapping("/create/group")
    public ResponseEntity createGroup(@RequestBody Auths auth) {
        try {
            return ResponseEntity.ok("All work");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body("Error in server");
        }
    }

    @PostMapping("/getUser")
    public ResponseEntity getUser(@RequestBody Auths auth) {
        try {
            return ResponseEntity.ok("All work");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body("Error in server");
        }
    }
}
