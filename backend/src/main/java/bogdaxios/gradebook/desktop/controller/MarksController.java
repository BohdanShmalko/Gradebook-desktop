package bogdaxios.gradebook.desktop.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/addMarks")
public class MarksController {

    @PostMapping("/marks")
    public ResponseEntity createMark() {
        try {
            return ResponseEntity.ok("All work");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error in server");
        }
    }

    @PostMapping("/practiceTable")
    public ResponseEntity createPracticeTable() {
        try {
            return ResponseEntity.ok("All work");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error in server");
        }
    }

    @PostMapping("/practice")
    public ResponseEntity createPractice() {
        try {
            return ResponseEntity.ok("All work");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error in server");
        }
    }

    @PostMapping("/atestations")
    public ResponseEntity createAtestations() {
        try {
            return ResponseEntity.ok("All work");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error in server");
        }
    }

    @PostMapping("/examsMarks")
    public ResponseEntity createExamsMarks() {
        try {
            return ResponseEntity.ok("All work");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error in server");
        }
    }

    @PostMapping("/degreeProject")
    public ResponseEntity createDegreeProject() {
        try {
            return ResponseEntity.ok("All work");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error in server");
        }
    }

    @PostMapping("/examinationCommission")
    public ResponseEntity createExaminationCommission() {
        try {
            return ResponseEntity.ok("All work");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error in server");
        }
    }
}
