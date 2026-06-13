package com.huongdanjava.systemdesign.outboxpattern.repository;

import com.huongdanjava.systemdesign.outboxpattern.repository.entity.Student;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, UUID> {

}
