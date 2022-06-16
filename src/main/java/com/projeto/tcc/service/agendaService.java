package com.projeto.tcc.service;
import com.projeto.tcc.model.Agenda;
import com.projeto.tcc.repository.agendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class agendaService {

    @Autowired
    private agendaRepository repository;

    public List<Agenda> getAll(){
        return this.repository.findAll();
    }

    public Agenda getById(Long id){
        return this.repository.findById(id).orElse(null);
    }

    public Agenda insertAgenda(Agenda a){
        return this.repository.save(a);
    }

    public Agenda updateAgenda(Long id, Agenda a){
        return this.repository.findById(id).map(
                body -> {
                    Agenda old = this.repository.findById(id).orElse(null);

                    if (a.getNome().isEmpty() || a.getNome() == null) {
                        a.setNome(old.getNome());
                    }
                    if (a.getCidade().isEmpty() || a.getCidade() == null) {
                        a.setCidade(old.getCidade());
                    }
                    if (a.getDescricao().isEmpty() || a.getDescricao() == null) {
                        a.setDescricao(old.getDescricao());
                    }
                    if (a.getEmail().isEmpty() || a.getEmail() == null) {
                        a.setEmail(old.getDescricao());
                    }
                    if (a.getEstado().isEmpty() || a.getEstado() == null) {
                        a.setEstado(old.getEstado());
                    }
                    if (a.getPais().isEmpty() || a.getPais() == null) {
                        a.setPais(old.getPais());
                    }
                    if (a.getTelefone().isEmpty() || a.getTelefone() == null) {
                        a.setTelefone(old.getTelefone());
                    }

                    body.setNome(a.getNome());
                    body.setCidade(a.getCidade());
                    body.setDescricao(a.getDescricao());
                    body.setEmail(a.getEmail());
                    body.setEstado(a.getEstado());
                    body.setPais(a.getPais());
                    body.setTelefone(a.getTelefone());

                    Agenda nova_agenda = repository.save(body);
                    return nova_agenda;

                }).orElse(null);
    }

    public void delete(Long id){
        this.repository.deleteById(id);
    }

}
