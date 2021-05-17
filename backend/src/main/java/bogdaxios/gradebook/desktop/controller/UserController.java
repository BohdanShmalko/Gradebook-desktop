package bogdaxios.gradebook.desktop.controller;

import bogdaxios.gradebook.desktop.exeptions.NotAuthorizedUser;
import bogdaxios.gradebook.desktop.exeptions.TokenIsBroken;
import bogdaxios.gradebook.desktop.model.user.*;
import bogdaxios.gradebook.desktop.exeptions.IncorrectLoginInformation;
import bogdaxios.gradebook.desktop.exeptions.UserAlreadyExist;
import bogdaxios.gradebook.desktop.service.user.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private AuthService authService;

    @Autowired
    private StudentAuthService studentAuthService;

    @Autowired
    private AdminAuthService adminAuthService;

    @Autowired
    private TeacherAuthService teacherAuthService;

    @Autowired
    private GroupAuthService groupAuthService;

    @PostMapping("/registration/student")
    public ResponseEntity createStudent(@RequestHeader("Authorization") String jwt, @RequestBody CreateStudent cs) {
        try {
            studentAuthService.registration(jwt, cs);
            return ResponseEntity.ok("ok");
        } catch (UserAlreadyExist | NotAuthorizedUser | TokenIsBroken e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error in server");
        }
    }

    @PostMapping("/registration/admin")
    public ResponseEntity createAdmin(@RequestHeader("Authorization") String jwt, @RequestBody CreateAdmin ca) {
        try {
            adminAuthService.registration(jwt, ca);
            return ResponseEntity.ok("ok");
        } catch (UserAlreadyExist | NotAuthorizedUser | TokenIsBroken e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error in server");
        }
    }

    @PostMapping("/create/teacher")
    public ResponseEntity createTeacher(@RequestHeader("Authorization") String jwt, @RequestBody CreateTeacher ct) {
        try {
            teacherAuthService.registration(jwt, ct);
            return ResponseEntity.ok("ok");
        } catch (UserAlreadyExist | NotAuthorizedUser | TokenIsBroken e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error in server");
        }
    }

    @PostMapping("/create/group")
    public ResponseEntity createGroup(@RequestHeader("Authorization") String jwt, @RequestBody CreateGroup cg) {
        try {
            groupAuthService.registration(jwt, cg);
            return ResponseEntity.ok("ok");
        } catch (UserAlreadyExist | NotAuthorizedUser | TokenIsBroken e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error in server");
        }
    }

    @PostMapping("/getUser")
    public ResponseEntity getUser(@RequestBody GetUser gu) {
        try {
            String token = authService.authentication(gu);
            return ResponseEntity.ok(token);
        } catch (IncorrectLoginInformation e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error in server");
        }
    }
}
