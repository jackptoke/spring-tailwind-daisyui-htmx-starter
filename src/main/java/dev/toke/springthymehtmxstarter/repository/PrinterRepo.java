package dev.toke.springthymehtmxstarter.repository;

import dev.toke.springthymehtmxstarter.data.model.Printer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrinterRepo extends JpaRepository<Printer, Long> {
    @Query(value = "SELECT * FROM Printer WHERE user_id = :userId", nativeQuery = true)
    List<Printer> findByUserId(Long userId);
    @Query(value = "SELECT P.* FROM Printer P " +
            "JOIN User U ON U.id = P.user_id " +
            "WHERE U.username = :username", nativeQuery = true)
    List<Printer> findByUsername(String username);
    @Query(value = "SELECT * FROM user_id = :userId AND printerIP = :printerIp", nativeQuery = true)
    Printer findByUserIdAndPrinterIp(Long userId, String printerIp);
}
