package com.api.lojamaterial.services;

import com.api.lojamaterial.model.Material;
import com.api.lojamaterial.respositories.MaterialRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MaterialService {
    @Autowired
    MaterialRepository repository;

    @Transactional
    public Material save(Material material){
        return repository.save(material);
    }

    public Page<Material> findAll(Pageable pageable){
        return repository.findAll(pageable);
    }

    public Optional<Material> findById(String id){
        return repository.findById(id);
    }

    @Transactional
    public void delete(Material material){
        repository.delete(material);
    }

}
