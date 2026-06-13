package com.huongdanjava.systemdesign.outboxpattern.controller;

import com.huongdanjava.systemdesign.outboxpattern.controller.dto.AddNewStudentRequest;
import com.huongdanjava.systemdesign.outboxpattern.repository.OutboxRepository;
import com.huongdanjava.systemdesign.outboxpattern.repository.StudentRepository;
import com.huongdanjava.systemdesign.outboxpattern.repository.entity.Outbox;
import com.huongdanjava.systemdesign.outboxpattern.repository.entity.Student;
import jakarta.transaction.Transactional;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tools.jackson.databind.ObjectMapper;

@RestController
public class StudentController {

  private final StudentRepository studentRepository;
  private final OutboxRepository outboxRepository;

  private final ObjectMapper om = new ObjectMapper();

  public StudentController(StudentRepository studentRepository, OutboxRepository outboxRepository) {
    this.studentRepository = studentRepository;
    this.outboxRepository = outboxRepository;
  }

  @PostMapping("/students")
  @Transactional
  ResponseEntity<String> addNewStudent(@RequestBody AddNewStudentRequest request) {
    Student student = new Student();
    student.setName(request.getName());
    student.setId(UUID.randomUUID());
    Student s = studentRepository.save(student);

    Outbox outbox = new Outbox();
    outbox.setId(UUID.randomUUID());
    outbox.setAggregateId(s.getId());
    outbox.setEventType("StudentCreated");
    outbox.setType("Student");
    outbox.setPayload(om.writeValueAsString(student));
    outboxRepository.save(outbox);

    return ResponseEntity.ok("Added new student");
  }

}
