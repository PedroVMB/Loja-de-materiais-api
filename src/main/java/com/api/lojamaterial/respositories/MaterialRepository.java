package com.api.lojamaterial.respositories;

import com.api.lojamaterial.model.Material;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialRepository extends JpaRepository<Material, String> {
}
