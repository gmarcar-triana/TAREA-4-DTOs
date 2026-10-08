package com.salestianostriana.com.repo;

import com.salestianostriana.com.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro, Long> {
}
