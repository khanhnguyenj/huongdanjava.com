package com.huongdanjava.systemdesign;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
  ResponseEntity<String> addNewStudent(@RequestParam String name) throws JsonProcessingException {
    Student student = new Student();
    student.setName(name);
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
