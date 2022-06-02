package com.projeto.tcc.controller;


import com.projeto.tcc.model.Agenda;
import com.projeto.tcc.service.agendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/agenda")
public class agendaController {

    @Autowired
    private agendaService service;

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<Agenda> getAgendas(){
        return this.service.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Agenda getAgendasById(@NotNull @PathVariable("id") Long id){
        return this.service.getById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Agenda insertAgenda(@RequestBody Agenda a){
        return this.service.insertAgenda(a);
    }

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Agenda updateAgenda(@NotNull @PathVariable("id") Long id, @RequestBody Agenda a){
        return this.service.updateAgenda(id,a);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void delete(@PathVariable("id") Long id){
        this.service.delete(id);
    }

}
