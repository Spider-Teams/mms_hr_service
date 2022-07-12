package com.mms.hr_service.services;

import com.mms.hr_service.entities.Employee;
import com.mms.hr_service.entities.LeaveRequest;
import com.mms.hr_service.repos.LeaveRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LeaveRequestService {
    @Autowired
    LeaveRequestRepository leaveRequestRepository;

    public Iterable<LeaveRequest> findAllLeaveRequest() {
        return leaveRequestRepository.findAll();
    }

    public ResponseEntity<Object> findLeaveRequestById(Long id) {
        Optional<LeaveRequest> leaveRequest = leaveRequestRepository.findById(id);
        if(leaveRequest.isPresent()) {
            return ResponseEntity.ok().body(leaveRequest.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public LeaveRequest createLeaveRequest(LeaveRequest leaveRequest) {
        return leaveRequestRepository.save(leaveRequest);
    }

    public ResponseEntity<LeaveRequest> updateLeaveRequest(LeaveRequest leaveRequest) {
        Optional<LeaveRequest> leaveRequestFind = leaveRequestRepository.findById(leaveRequest.getId());
        if(leaveRequestFind.isPresent()) {
            return ResponseEntity.ok().body(leaveRequestRepository.save(leaveRequest));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public void deleteLeaveRequest(Long id) {
        leaveRequestRepository.deleteById(id);
    }

}
