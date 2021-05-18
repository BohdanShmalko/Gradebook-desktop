package bogdaxios.gradebook.desktop.controller;

import bogdaxios.gradebook.desktop.exeptions.NotAuthorizedUser;
import bogdaxios.gradebook.desktop.exeptions.TokenIsBroken;
import bogdaxios.gradebook.desktop.model.marks.Atestation;
import bogdaxios.gradebook.desktop.model.marks.DegreeProject;
import bogdaxios.gradebook.desktop.model.marks.Mark;
import bogdaxios.gradebook.desktop.model.marks.Practice;
import bogdaxios.gradebook.desktop.model.user.CreateStudent;
import bogdaxios.gradebook.desktop.service.marks.CreateAtestationsService;
import bogdaxios.gradebook.desktop.service.marks.CreateDegreeProjectService;
import bogdaxios.gradebook.desktop.service.marks.CreateMarkService;
import bogdaxios.gradebook.desktop.service.marks.CreatePracticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addMarks")
public class MarksController {
    @Autowired
    private CreatePracticeService createPracticeService;

    @Autowired
    private CreateMarkService createMarkService;

    @Autowired
    private CreateAtestationsService createAtestationsService;

    @Autowired
    private CreateDegreeProjectService createDegreeProjectService;

    @PostMapping("/marks")
    public ResponseEntity createMark(@RequestHeader("Authorization") String jwt, @RequestBody Mark mark) {
        try {
            createMarkService.saveInf(jwt, mark);
            return ResponseEntity.ok("ok");
        } catch (NotAuthorizedUser | TokenIsBroken e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error in server");
        }
    }

    @PostMapping("/practice")
    public ResponseEntity createPractice(@RequestHeader("Authorization") String jwt, @RequestBody Practice practice) {
        try {
            createPracticeService.saveInf(jwt, practice);
            return ResponseEntity.ok("ok");
        } catch (NotAuthorizedUser | TokenIsBroken e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error in server");
        }
    }

    @PostMapping("/atestations")
    public ResponseEntity createAtestations(@RequestHeader("Authorization") String jwt, @RequestBody Atestation atestation) {
        try {
            createAtestationsService.saveInf(jwt, atestation);
            return ResponseEntity.ok("ok");
        } catch (NotAuthorizedUser | TokenIsBroken e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error in server");
        }
    }

    @PostMapping("/degreeProject")
    public ResponseEntity createDegreeProject(@RequestHeader("Authorization") String jwt, @RequestBody DegreeProject degreeProject) {
        try {
            createDegreeProjectService.saveInf(jwt, degreeProject);
            return ResponseEntity.ok("ok");
        } catch (NotAuthorizedUser | TokenIsBroken e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error in server");
        }
    }
}
