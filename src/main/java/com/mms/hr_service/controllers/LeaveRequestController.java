package com.mms.hr_service.controllers;

import com.mms.hr_service.entities.Employee;
import com.mms.hr_service.entities.LeaveRequest;
import com.mms.hr_service.services.LeaveRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/leaveRequest")
public class LeaveRequestController {
    @Autowired
    LeaveRequestService leaveRequestService;

    @GetMapping("/all")
    public Iterable<LeaveRequest> findAllLeaveRequest() {
        return leaveRequestService.findAllLeaveRequest();
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> findLeaveRequestById(@PathVariable(value = "id") Long id) {
        return leaveRequestService.findLeaveRequestById(id);
    }

    @PostMapping
    public LeaveRequest createLeaveRequest(@RequestBody LeaveRequest leaveRequest) {
        return leaveRequestService.createLeaveRequest(leaveRequest);
    }

    @PutMapping
    public ResponseEntity<LeaveRequest> updateLeaveRequest(@RequestBody LeaveRequest leaveRequest) {
        return leaveRequestService.updateLeaveRequest(leaveRequest);
    }

    @DeleteMapping("{id}")
    public void deleteLeaveRequest(@PathVariable(value = "id") Long id) {
        leaveRequestService.deleteLeaveRequest(id);
    }
}
