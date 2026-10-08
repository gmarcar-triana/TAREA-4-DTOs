package com.salestianostriana.com.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Autor {

    @Id @GeneratedValue
    Long id;
    String nombre;
    String apellido1;
    String apellido2;
    String nacionalidad;


}
