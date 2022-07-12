package com.mms.hr_service.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "hr_leaveRequest")
public class LeaveRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date fromDate;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date toDate;
    private Long leaveType;
    private String reason;
    private String createdBy;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Timestamp createdDate;
    private String supervisor;
    private String lineManager;
    private Long approval;
    private String approvalNote;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Timestamp approvedDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public Long getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(Long leaveType) {
        this.leaveType = leaveType;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public String getLineManager() {
        return lineManager;
    }

    public void setLineManager(String lineManager) {
        this.lineManager = lineManager;
    }

    public Long getApproval() {
        return approval;
    }

    public void setApproval(Long approval) {
        this.approval = approval;
    }

    public String getApprovalNote() {
        return approvalNote;
    }

    public void setApprovalNote(String approvalNote) {
        this.approvalNote = approvalNote;
    }

    public Timestamp getApprovedDate() {
        return approvedDate;
    }

    public void setApprovedDate(Timestamp approvedDate) {
        this.approvedDate = approvedDate;
    }
}
