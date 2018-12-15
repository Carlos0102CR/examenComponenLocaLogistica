package com.cenfotec.localogistica.web;

import com.cenfotec.localogistica.domain.Factura;
import com.cenfotec.localogistica.domain.Paquete;
import com.cenfotec.localogistica.repository.FacturaRepository;
import com.cenfotec.localogistica.repository.PaqueteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

@Controller
@RequestMapping("/factura")
public class FacturaController {

    @Autowired
    PaqueteRepository repoPaq;

    @Autowired
    FacturaRepository repo;

    @PostMapping
    public ResponseEntity facturaRegistrar(@RequestBody Factura factura) {

        Optional<Paquete> opt = repoPaq.findById(factura.getPaquete().getIdPaquete());
        if (opt.isPresent() == false) {
            return new ResponseEntity(HttpStatus.FAILED_DEPENDENCY);
        }
        repo.save(factura);
        Paquete paquete = opt.get();
        paquete.setVueloDestino(obtenerFechaProximoVuelo());
        repoPaq.save(paquete);

        return new ResponseEntity(HttpStatus.OK);
    }

    private String obtenerFechaProximoVuelo() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        int anno = cal.get(Calendar.YEAR);
        int mes = cal.get(Calendar.MONTH) + 1;
        int dia = cal.get(Calendar.DAY_OF_MONTH) + 1;
        return "" + anno + mes + dia;
    }
}
