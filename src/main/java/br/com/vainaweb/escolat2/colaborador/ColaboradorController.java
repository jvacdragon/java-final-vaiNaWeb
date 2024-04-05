package br.com.vainaweb.escolat2.colaborador;

import br.com.vainaweb.escolat2.enuns.Cargo;
import br.com.vainaweb.escolat2.repository.ColaboradorRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/colaborador")
public class ColaboradorController {

    private ColaboradorRepository colaboradorRepository;

    //Constructor Injection
    public ColaboradorController(ColaboradorRepository colaboradorRepository){
        this.colaboradorRepository = colaboradorRepository;
    }

    @GetMapping
    public ResponseEntity<List<Colaborador>> colaboradorRetrieveAll(){

        return ResponseEntity.status(HttpStatus.OK).body(colaboradorRepository.findAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Colaborador> retrieveColaboradorById(@PathVariable long id){

        //Verificando se colaborador com essa id existe e retornando erro caso não exista
        Optional<Colaborador> o =  colaboradorRepository.findById(id);
        if(o.isEmpty()) throw new ColaboradorNotFoundException("Colaborador de id " +id+ " não encontrado");

        return ResponseEntity.status(HttpStatus.OK).body(o.get());
    }

    @PostMapping
    public ResponseEntity<Colaborador> colaboradorSave(@Valid @RequestBody ColaboradorDTO alunoDTO){

        var colaborador = new Colaborador(alunoDTO.name(), alunoDTO.email(), alunoDTO.cpf(),
                Cargo.fromString(alunoDTO.cargo()), alunoDTO.endereco());


        return ResponseEntity.status(HttpStatus.CREATED).body(colaboradorRepository.save(colaborador));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Colaborador> deleteById(@PathVariable long id){

        //Verificando se colaborador com essa id existe e retornando erro caso não exista
        Optional<Colaborador> o = colaboradorRepository.findById(id);
        if (o.isEmpty()) throw new ColaboradorNotFoundException("Colaborador de id " + id + " não encontrado");

        colaboradorRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PatchMapping(path = "/{id}")
    public ResponseEntity<Colaborador> updateById(@PathVariable long id, @Valid @RequestBody ColaboradorDTO colaborador){

            //Verificando se colaborador com essa id existe e retornando erro caso não exista
            Optional<Colaborador> o = colaboradorRepository.findById(id);
            if (o.isEmpty()) throw new ColaboradorNotFoundException("Colaborador de id " + id + " não encontrado");

            Colaborador c = o.get();

            //Verificando apenas os dados que podem ser alterados e os alterando caso necessário
            if (colaborador.email() != null && !colaborador.email().isEmpty()) c.setEmail(colaborador.email());
            if (colaborador.cargo() != null && !colaborador.cargo().isEmpty()) c.setCargo(Cargo.fromString(colaborador.cargo()));
            if (colaborador.name() != null && !colaborador.cargo().isEmpty()) c.setName(colaborador.name());

            return ResponseEntity.status(HttpStatus.OK).body(colaboradorRepository.save(c));
    }
}
