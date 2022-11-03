package com.k8s.repository;

import com.k8s.model.Birim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;

import java.util.List;
import java.util.UUID;

public interface BirimRepository extends JpaRepository<Birim, UUID> {

    @Procedure
    Integer get_birim_yil_prodecure(int yil);

    @Procedure
    Integer get_birim_sum_prodecure(String ad);


    @Procedure
    List<Birim> get_birim_list_function();

    @Modifying
    @Query(value = "CALL create_birim_prodecure(:id,:ad,:kod,:yil,:count);", nativeQuery = true)
    void create_birim_prodecure(UUID id, String ad, String kod, int yil, int count);

    @Modifying
    @Query(value = "CALL update_birim_prodecure(:id,:ad,:kod,:yil,:count);", nativeQuery = true)
    void update_birim_prodecure(UUID id, String ad, String kod, int yil, int count);

    @Modifying
    @Query(value = "CALL delete_birim_prodecure(:id);", nativeQuery = true)
    void delete_birim_prodecure(UUID id);
}

