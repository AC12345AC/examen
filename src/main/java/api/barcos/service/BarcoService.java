package api.barcos.service;

import api.barcos.entity.Barco;
import api.barcos.repository.BarcoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class BarcoService {

    @Autowired
    private BarcoRepository barcoRepository;

    public Barco add(Barco barco) {
        return barcoRepository.save(barco);
    }

    public List<Barco> get() {
        return barcoRepository.findAll();
    }

    public Optional<Barco> getById(int id) {
        return barcoRepository.findById(id);
    }

    public void delete(int id) {
        barcoRepository.deleteById(id);
    }

    public Barco update(int id, Barco barco) {
        Optional<Barco> existingBarco = barcoRepository.findById(id);
        if (existingBarco.isPresent()) {
            Barco updatedBarco = existingBarco.get();
            updatedBarco.setNombre(barco.getNombre());
            updatedBarco.setOrigen(barco.getOrigen());
            updatedBarco.setDestino(barco.getDestino());
            updatedBarco.setCapacidad(barco.getCapacidad());
            return barcoRepository.save(updatedBarco);
        } else {
            throw new RuntimeException("Barco no encontrado con ID: " + id);
        }
    }

    
}
