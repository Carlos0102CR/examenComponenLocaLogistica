package com.cenfotec.localogistica.web;


import com.cenfotec.localogistica.domain.Paquete;
import com.cenfotec.localogistica.repository.PaqueteRepository;
import com.cenfotec.localogistica.repository.PreAlertaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/paquete")
public class PaqueteController {

    @Autowired
    PaqueteRepository repo;

    @Autowired
    PreAlertaRepository repoPre;

    @PostMapping
    public ResponseEntity paqueteRegistrar(@RequestBody Paquete paquete) {
        paquete.setFechaHora(new Date());

        if (repoPre.findByIdCourier(paquete.getIdCourier()) != null) {
            paquete.setVueloDestino(obtenerFechaProximoVuelo());
        }
        repo.save(paquete);

        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping
    @ResponseBody
    public List<Paquete> listarSigVuelo() {
        String vuelo = obtenerFechaProximoVuelo();
        List<Paquete> paquetes = repo.findAllByVueloDestino(vuelo);
        return paquetes;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public List<Paquete> listarPorCuenta(@PathVariable Long id) {
        List<Paquete> paquetes = repo.findAllByNumCuentaCosignatario(id);
        return paquetes;
    }

    @GetMapping("/sinvuelo")
    @ResponseBody
    public List<Paquete> listarSinVuelo() {
        List<Paquete> paquetes = repo.findAllByVueloDestino(null);
        return paquetes;
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
