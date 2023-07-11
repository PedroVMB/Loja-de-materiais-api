package com.api.lojamaterial.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "tb_materiais")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Material implements Serializable {
    @Serial
    public static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "nome_material", nullable = false)
    private String nome;

    @Column(name = "valor_material", nullable = false)
    public String valor;

    @Column(name = "foto_material", nullable = true)
    public String foto;
}
