package com.Backend.PACER.controllers;

import com.Backend.PACER.entities.CaseAccessHistory;
import com.Backend.PACER.entities.LoginHistory;
import com.Backend.PACER.services.CaseAccessHistoryService;
import com.Backend.PACER.services.LoginHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublicController {

    @Autowired
    private LoginHistoryService loginHistoryService;

    @Autowired
    private CaseAccessHistoryService caseAccessHistoryService;

    @PostMapping("/login-history")
    public LoginHistory createLoginHistory(@RequestBody LoginHistory loginHistory) {
        return loginHistoryService.createLoginHistory(loginHistory);
    }

    @PostMapping("/case-history")
    public CaseAccessHistory createHistory(@RequestBody CaseAccessHistory history) {
        return caseAccessHistoryService.createCaseAccessHistory(history);
    }

}
