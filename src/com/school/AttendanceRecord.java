package com.school;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AttendanceRecord implements Storable {
    private Student student;
    private Course course;
    private String status;
    private LocalDateTime timestamp;
    
    public AttendanceRecord(Student student, Course course, String status) {
        this.student = student;
        this.course = course;
        this.status = status;
        this.timestamp = LocalDateTime.now();
    }
    
    // Getters
    public Student getStudent() {
        return student;
    }
    
    public Course getCourse() {
        return course;
    }
    
    public String getStatus() {
        return status;
    }
    
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    
    // Setters
    public void setStatus(String status) {
        this.status = status;
    }
    
    @Override
    public String toDataString() {
        // Format: studentId,courseId,status,timestamp
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return student.getId() + "," + course.getCourseId() + "," + status + "," + timestamp.format(formatter);
    }
    
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return String.format("Student: %s (ID: %d) | Course: %s (ID: C%d) | Status: %s | Time: %s",
                student.getName(), student.getId(),
                course.getCourseName(), course.getCourseId(),
                status, timestamp.format(formatter));
    }
}
