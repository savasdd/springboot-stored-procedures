package com.k8s.service;

import com.k8s.model.Birim;
import com.k8s.repository.BirimRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@Slf4j
public class BirimServiceImpl {

    @Autowired
    private BirimRepository repository;

    public Birim create(Birim dto) {
        Birim newBirim = repository.save(dto);
        return newBirim;
    }

    public List<Birim> getAll() {
        return repository.findAll();
    }

    public Integer getByYear(int yil) {
        return repository.get_birim_yil_prodecure(yil);
    }

    public Integer getSumCount(String ad) {
        return repository.get_birim_sum_prodecure(ad);
    }

    public List<Birim> get_birim_list_function() {
        return repository.get_birim_list_function();
    }

    public void createProcedure(Birim dto) {
        UUID uuid = UUID.randomUUID();
        log.info("Create: " + uuid.toString());
        repository.create_birim_prodecure(uuid, dto.getAd(), dto.getKod(), dto.getYil().intValue(), dto.getCount().intValue());
    }

    public void updateProcedure(String id, Birim dto) {
        log.info("Update: " + id);
        repository.update_birim_prodecure(UUID.fromString(id), dto.getAd(), dto.getKod(), dto.getYil().intValue(), dto.getCount().intValue());
    }

    public void deleteProcedure(String id) {
        log.info("Delete: " + id);
        repository.delete_birim_prodecure(UUID.fromString(id));
    }
}
