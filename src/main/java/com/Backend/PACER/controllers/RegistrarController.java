package com.Backend.PACER.controllers;

import com.Backend.PACER.entities.*;
import com.Backend.PACER.services.CaseAccessHistoryService;
import com.Backend.PACER.services.CourtCaseService;
import com.Backend.PACER.services.HearingService;
import com.Backend.PACER.services.LoginHistoryService;
import com.Backend.PACER.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/registrar")
@CrossOrigin(origins = "http://localhost:3000") // Add this if frontend is on a different port
public class RegistrarController {

    @Autowired
    private UserService userService ;

    @Autowired
    private LoginHistoryService loginHistoryService;

    @Autowired
    private CaseAccessHistoryService caseAccessHistoryService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private HearingService hearingService;

    @Autowired
    private CourtCaseService courtCaseService;

//    User Controllers

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        userDetails.setPassword(passwordEncoder.encode(userDetails.getPassword()));
        User updatedUser = userService.updateUser(id, userDetails);
        return updatedUser != null ? ResponseEntity.ok(updatedUser) : ResponseEntity.notFound().build();
    }

//    @PostMapping("/users")
//    public ResponseEntity<String> createUser(@RequestBody User user){
//		Optional<User> isUser = userService.findByUsername(user.getUsername());
//		if (isUser.isPresent()) {
//			return new ResponseEntity<>("User Already exit", HttpStatus.ALREADY_REPORTED);
//		}
//		user.setPassword(passwordEncoder.encode(user.getPassword()));
//		userService.createUser(user);
//		return ResponseEntity.ok("Saved successfully");
//    }
//

    @PostMapping("/users")
    public ResponseEntity<?> addUser(@RequestPart("user") User user, @RequestPart("imageFile") MultipartFile imageFile) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        try {
            User createdUser = userService.createUser(user, imageFile);
            return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        User user = userService.getUserById(id);
        return user!=null ? ResponseEntity.ok(user) :
                ResponseEntity.notFound().build();
    }


//    Login History Details


    @GetMapping("/login-history/{userId}")
    public List<LoginHistory> getLoginHistory(@PathVariable Long userId){
        return loginHistoryService.getLoginHistoryByUserId(userId);
    }



    //    Case Access History details
    @GetMapping("/case-history/{cin}")
    public List<CaseAccessHistory> getCaseAccessHistory(@PathVariable Long cin) {
        return caseAccessHistoryService.getByCaseId(cin);
    }



//    Hearing Details
    @PostMapping("/cases/hearing")
    public Hearing addHearing(@RequestBody Hearing hearing) {
    return hearingService.addHearing(hearing);
    }




    @GetMapping("/court-cases/status/{status}")
    public List<CourtCase> listPendingCases(@PathVariable String status) {
        if (status.equalsIgnoreCase("pending"))
            return courtCaseService.listPendingCases(status);
        if (status.equalsIgnoreCase("resolved"))
            return courtCaseService.listResolvedCases(status);
        return null;
    }

    @PostMapping("/court-cases")
    public CourtCase createCourtCase(@RequestBody CourtCase courtCase) {
        return courtCaseService.createCourtCase(courtCase);
    }


    @PutMapping("/court-cases/{cin}")
    public ResponseEntity<CourtCase> updateCourtCase(@PathVariable Long cin, @RequestBody CourtCase courtCaseDetails) {
        courtCaseDetails.setCin(cin); // Ensure the cin is set from the path
        CourtCase updatedCourtCase = courtCaseService.updateCourtCase(cin, courtCaseDetails);
        return ResponseEntity.ok(updatedCourtCase); // Return the updated entity
    }

}
