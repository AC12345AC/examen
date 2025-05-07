package api.barcos.controller;

import api.barcos.entity.Barco;
import api.barcos.service.BarcoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "*") // Permitir acceso desde cualquier origen
@Tag(name = "Barcos", description = "API para gestionar barcos") // Grupo en Swagger
@RestController
@RequestMapping("/barcos")
public class BarcoController {

    @Autowired
    private BarcoService barcoService;

    @GetMapping
    @Operation(summary = "Obtener todos los barcos", description = "Devuelve una lista de todos los barcos")
    public List<Barco> get() {
        return barcoService.get();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener un barco por ID", description = "Devuelve un barco según su ID")
    public Optional<Barco> getById(@PathVariable int id) {
        return barcoService.getById(id);
    }

    @PostMapping
    @Operation(summary = "Crear un nuevo barco", description = "Agrega un nuevo barco a la base de datos")
    public Barco add(@RequestBody Barco barco) {
        return barcoService.add(barco);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modificar un barco", description = "Modifica un barco existente")
    public Barco update(@PathVariable int id, @RequestBody Barco barco) {
        return barcoService.update(id, barco);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un barco", description = "Elimina un barco de la base de datos")
    public void delete(@PathVariable int id) {
        barcoService.delete(id);
    }


    
}
