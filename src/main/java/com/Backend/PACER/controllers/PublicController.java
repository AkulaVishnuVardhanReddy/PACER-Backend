package com.Backend.PACER.controllers;

import com.Backend.PACER.entities.CaseAccessHistory;
import com.Backend.PACER.entities.Hearing;
import com.Backend.PACER.entities.LoginHistory;
import com.Backend.PACER.entities.User;
import com.Backend.PACER.services.CaseAccessHistoryService;
import com.Backend.PACER.services.HearingService;
import com.Backend.PACER.services.LoginHistoryService;
import com.Backend.PACER.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PublicController {

    @Autowired
    private LoginHistoryService loginHistoryService;

    @Autowired
    private HearingService hearingService;

    @Autowired
    private CaseAccessHistoryService caseAccessHistoryService;

    @Autowired
    private UserService userService;

    @PostMapping("/login-history")
    public LoginHistory createLoginHistory(@RequestBody LoginHistory loginHistory) {
        return loginHistoryService.createLoginHistory(loginHistory);
    }

    @PostMapping("/case-history")
    public CaseAccessHistory createHistory(@RequestBody CaseAccessHistory history) {
        return caseAccessHistoryService.createCaseAccessHistory(history);
    }

    @GetMapping("/findUserId/{username}")
    public ResponseEntity<Long> findUserIdByUserName(@PathVariable String username) {
        Optional<User> user = userService.findByUsername(username);
        return ResponseEntity.ok(user.get().getId());
    }

    @GetMapping("/findFirstName/{username}")
    public ResponseEntity<String> findFirstNameByUserName(@PathVariable String username) {
        Optional<User> user = userService.findByUsername(username);
        return ResponseEntity.ok(user.get().getFirstName());
    }

    @GetMapping("/user-profile/{username}")
    public ResponseEntity<User> getUserProfile(@PathVariable String username) {
        Optional<User> user = userService.findByUsername(username);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/cases/hearing/{cin}")
    public List<Hearing> getByCin(@PathVariable Long cin) {
        return hearingService.hearingListOfCase(cin);
    }

    @GetMapping("/hearing/{keyword}")
    public List<Hearing> getByKeyword(@PathVariable String keyword) {
        return hearingService.findByKeyword(keyword);
    }

}
