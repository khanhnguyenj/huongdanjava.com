package com.huongdanjava.systemdesign.outboxpattern.repository;

import com.huongdanjava.systemdesign.outboxpattern.repository.entity.Outbox;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OutboxRepository extends JpaRepository<Outbox, UUID> {

}
