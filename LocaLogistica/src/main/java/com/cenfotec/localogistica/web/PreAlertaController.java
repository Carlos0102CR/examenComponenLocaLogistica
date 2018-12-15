package com.cenfotec.localogistica.web;

import com.cenfotec.localogistica.domain.PreAlerta;
import com.cenfotec.localogistica.repository.PreAlertaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/prealerta")
public class PreAlertaController {

    @Autowired
    PreAlertaRepository repo;

    @PostMapping
    public ResponseEntity preAlertaRegistrar(@RequestBody PreAlerta preAlerta) {
        repo.save(preAlerta);

        return new ResponseEntity(HttpStatus.OK);
    }
}
