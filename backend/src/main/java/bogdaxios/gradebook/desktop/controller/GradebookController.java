package bogdaxios.gradebook.desktop.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gradebook")
public class GradebookController {

    @GetMapping("/information")
    public ResponseEntity getInf() {
        try {
            return ResponseEntity.ok("All work");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error in server");
        }
    }

    @GetMapping("/marks")
    public ResponseEntity getMark() {
        try {
            return ResponseEntity.ok("All work");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error in server");
        }
    }

    @GetMapping("/practiceTable")
    public ResponseEntity getPracticeTable() {
        try {
            return ResponseEntity.ok("All work");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error in server");
        }
    }

    @GetMapping("/practice")
    public ResponseEntity getPractice() {
        try {
            return ResponseEntity.ok("All work");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error in server");
        }
    }

    @GetMapping("/atestations")
    public ResponseEntity getAtestations() {
        try {
            return ResponseEntity.ok("All work");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error in server");
        }
    }

    @GetMapping("/examsMarks")
    public ResponseEntity getExamsMarks() {
        try {
            return ResponseEntity.ok("All work");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error in server");
        }
    }

    @GetMapping("/degreeProject")
    public ResponseEntity getDegreeProject() {
        try {
            return ResponseEntity.ok("All work");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error in server");
        }
    }

    @GetMapping("/examinationCommission")
    public ResponseEntity getExaminationCommission() {
        try {
            return ResponseEntity.ok("All work");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error in server");
        }
    }


}
