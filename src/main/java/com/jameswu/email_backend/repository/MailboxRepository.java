package com.jameswu.email_backend.repository;
import org.springframework.stereotype.Repository;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Optional;

import com.jameswu.email_backend.model.Mailbox;

@Repository
public interface MailboxRepository extends JpaRepository<Mailbox, UUID> {
    @Query(
        value = """
                SELECT id
                FROM mailbox
                WHERE data->>'name' = :name
                """,
        nativeQuery = true
    )
    Optional<UUID> findIdByName(@Param("name") String name);

    @Query(
        value = """
                SELECT data->>'name' AS name
                FROM mailbox
                WHERE id = :id
                """,
        nativeQuery = true
    )
    Optional<String> findNameById(@Param("id") UUID id);
}
