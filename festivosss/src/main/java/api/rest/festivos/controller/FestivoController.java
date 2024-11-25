package api.rest.festivos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.rest.festivos.service.FestivoService;

@RestController
@RequestMapping("/festivos")
public class FestivoController {
    @Autowired
    private FestivoService festivoService;

    @GetMapping("/verificar/{anio}/{mes}/{dia}")
    public ResponseEntity<String> verificarFestivo(
            @PathVariable int anio,
            @PathVariable int mes,
            @PathVariable int dia) {
        String respuesta = festivoService.verificarFestivo(anio, mes, dia);
        return ResponseEntity.ok(respuesta);
    }
}

