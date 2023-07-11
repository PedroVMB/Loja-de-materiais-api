package com.api.cadastrofuncionarios.lambda.controller;

import com.api.lojamaterial.dto.MaterialDto;
import com.api.lojamaterial.enums.GeneralMessages;
import com.api.lojamaterial.model.Material;
import com.api.lojamaterial.services.MaterialService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/material")
public class MaterialController {

    @Autowired
    public MaterialService service;

    @PostMapping
    public ResponseEntity<Object> saveMaterial(@RequestBody @Valid MaterialDto materialDto){
        var materialModel = new Material();
        BeanUtils.copyProperties(materialDto, materialModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(materialModel));
    }
    @GetMapping
    public ResponseEntity<Page<Material>> getAllMaterials(@PageableDefault(page = 0, size = 10, sort = "id",
            direction = Sort.Direction.ASC)Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneMaterial(@PathVariable(value = "id") String id){
        Optional<Material> materialModelOptional = service.findById(id);
        if (!materialModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(GeneralMessages.MATERIAL_NOT_FOUND);
        }
        return ResponseEntity.status(HttpStatus.OK).body(materialModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteMaterial(@PathVariable(value = "id") String id){
        Optional<Material> materialModelOptional = service.findById(id);
        if (!materialModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(GeneralMessages.MATERIAL_NOT_FOUND);
        }
        service.delete(materialModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body(GeneralMessages.MATERIAL_DELETED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateMaterials(@PathVariable(value = "id") String id, @RequestBody @Valid MaterialDto materialDto){
        Optional<Material> materialModelOptional = service.findById(id);
        if(!materialModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(GeneralMessages.MATERIAL_NOT_FOUND);
        }
        var parkingSpotModel = new Material();
        BeanUtils.copyProperties(materialDto, parkingSpotModel);
        parkingSpotModel.setId(materialModelOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body("UPDATED PARKING SPOT");
    }




}
