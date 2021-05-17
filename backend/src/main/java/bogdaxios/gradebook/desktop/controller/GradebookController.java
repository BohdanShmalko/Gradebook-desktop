package bogdaxios.gradebook.desktop.controller;

import bogdaxios.gradebook.desktop.exeptions.NotAuthorizedUser;
import bogdaxios.gradebook.desktop.exeptions.TokenIsBroken;
import bogdaxios.gradebook.desktop.service.gradebook.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gradebook")
public class GradebookController {
    @Autowired
    private InformationService informationService;

    @Autowired
    private MarksService marksService;

    @Autowired
    private PracticeTableService practiceTableService;

    @Autowired
    private PracticeService practiceService;

    @Autowired
    private AtestationsService atestationsService;

    @Autowired
    private ExamsMarksService examsMarksService;

    @Autowired
    private DegreeProjectService degreeProjectService;

    @Autowired
    private ExaminationCommissionService examinationCommissionService;


    @GetMapping("/information")
    public ResponseEntity getInf(@RequestHeader("Authorization") String jwt) {
        try {
            return ResponseEntity.ok(informationService.getInf(jwt));
        } catch (NotAuthorizedUser | TokenIsBroken e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error in server");
        }
    }

    @GetMapping("/marks")
    public ResponseEntity getMark(@RequestParam int pageNumber, @RequestHeader("Authorization") String jwt) {
        try {
            return ResponseEntity.ok(marksService.getInf(jwt, pageNumber));
        } catch (NotAuthorizedUser | TokenIsBroken e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error in server");
        }
    }

    @GetMapping("/practiceTable")
    public ResponseEntity getPracticeTable(@RequestHeader("Authorization") String jwt) {
        try {
            return ResponseEntity.ok(practiceTableService.getInf(jwt));
        } catch (NotAuthorizedUser | TokenIsBroken e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error in server");
        }
    }

    @GetMapping("/practice")
    public ResponseEntity getPractice(@RequestHeader("Authorization") String jwt) {
        try {
            return ResponseEntity.ok(practiceService.getInf(jwt));
        } catch (NotAuthorizedUser | TokenIsBroken e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error in server");
        }
    }

    @GetMapping("/atestations")
    public ResponseEntity getAtestations(@RequestHeader("Authorization") String jwt) {
        try {
            return ResponseEntity.ok(atestationsService.getInf(jwt));
        } catch (NotAuthorizedUser | TokenIsBroken e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error in server");
        }
    }

    @GetMapping("/examsMarks")
    public ResponseEntity getExamsMarks(@RequestHeader("Authorization") String jwt) {
        try {
            return ResponseEntity.ok(examsMarksService.getInf(jwt));
        } catch (NotAuthorizedUser | TokenIsBroken e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error in server");
        }
    }

    @GetMapping("/degreeProject")
    public ResponseEntity getDegreeProject(@RequestHeader("Authorization") String jwt) {
        try {
            return ResponseEntity.ok(degreeProjectService.getInf(jwt));
        } catch (NotAuthorizedUser | TokenIsBroken e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error in server");
        }
    }

    @GetMapping("/examinationCommission")
    public ResponseEntity getExaminationCommission(@RequestHeader("Authorization") String jwt) {
        try {
            return ResponseEntity.ok(examinationCommissionService.getInf(jwt));
        } catch (NotAuthorizedUser | TokenIsBroken e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error in server");
        }
    }


}
