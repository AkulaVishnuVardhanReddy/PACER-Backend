package com.Backend.PACER.controllers;

import com.Backend.PACER.entities.*;
import com.Backend.PACER.services.CaseAccessHistoryService;
import com.Backend.PACER.services.CourtCaseService;
import com.Backend.PACER.services.HearingService;
import com.Backend.PACER.services.LoginHistoryService;
import com.Backend.PACER.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/registrar")
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
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user){
        User modifiedUser = userService.updateUser(id, user);
        return modifiedUser !=null ?ResponseEntity.ok(modifiedUser) :
                ResponseEntity.notFound().build();
    }

    @PostMapping("/users")
    public ResponseEntity<String> createUser(@RequestBody User user){
		Optional<User> isUser = userService.findByUsername(user.getUsername());
		if (isUser.isPresent()) {
			return new ResponseEntity<>("User Already exit", HttpStatus.ALREADY_REPORTED);
		}
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userService.createUser(user);
		return ResponseEntity.ok("Saved successfully");
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        User user = userService.getUserById(id);
        return user!=null ? ResponseEntity.ok(user) :
                ResponseEntity.notFound().build();
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }


//    Login History Details
    @PostMapping("/loginHistory")
    public LoginHistory createLoginHistory(@RequestBody LoginHistory loginHistory) {
        return loginHistoryService.createLoginHistory(loginHistory);
    }

    @GetMapping("/loginHistory/{userId}")
    public List<LoginHistory> getLoginHistory(@PathVariable Long userId){
        return loginHistoryService.getLoginHistoryByUserId(userId);
    }



//    Case Access History details
    @GetMapping("/case-history/{userId}")
    public List<CaseAccessHistory> getCaseAccessHistory(@PathVariable Long userId){
        return caseAccessHistoryService.getByCaseId(userId);
    }

    @PostMapping("/case-history")
    public CaseAccessHistory createHistory(@RequestBody CaseAccessHistory history) {
        return caseAccessHistoryService.createCaseAccessHistory(history);
    }


//    Hearing Details
    @PostMapping("/cases/hearing")
    public Hearing addHearing(@RequestBody Hearing hearing) {
    return hearingService.addHearing(hearing);
    }

    @GetMapping("/cases/hearing/{cin}")
    public List<Hearing> getByCin(@PathVariable Long cin){
        return hearingService.hearingListOfCase(cin);
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

}
