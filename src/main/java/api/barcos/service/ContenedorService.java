package api.barcos.service;

import api.barcos.entity.Contenedor;
import api.barcos.repository.ContenedorRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class ContenedorService {

    @Autowired
    private ContenedorRepository contenedorRepository;

    public Contenedor add(Contenedor contenedor) {
        return contenedorRepository.save(contenedor);
    }

    public List<Contenedor> get() {
        return contenedorRepository.findAll();
    }

    public Optional<Contenedor> getById(int id) {
        return contenedorRepository.findById(id);
    }

    public void delete(int id) {
        contenedorRepository.deleteById(id);
    }

    public Contenedor update(int id, Contenedor contenedor) {
        Optional<Contenedor> existingContenedor = contenedorRepository.findById(id);
        if (existingContenedor.isPresent()) {
            Contenedor updatedContenedor = existingContenedor.get();
            updatedContenedor.setVin(contenedor.getVin());
            updatedContenedor.setFecha(contenedor.getFecha());
            updatedContenedor.setBarco(contenedor.getBarco());
            return contenedorRepository.save(updatedContenedor);
        } else {
            throw new RuntimeException("Contenedor no encontrado con ID: " + id);
        }
    }

    public List<Contenedor> findByBarcoId(Long id) {
        return contenedorRepository.findByBarcoId(id);
    }
    



}
