package br.com.vainaweb.escolat2.aluno;

import br.com.vainaweb.escolat2.enuns.Curso;
import br.com.vainaweb.escolat2.repository.AlunoRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/aluno")
public class AlunoController {

    private AlunoRepository alunoRepository;

    public AlunoController(AlunoRepository alunoRepository){
        this.alunoRepository = alunoRepository;
    }

    @GetMapping
    public ResponseEntity<List<Aluno>> alunoRetrieveAll(){

        return ResponseEntity.status(HttpStatus.OK).body(alunoRepository.findAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Aluno> retrieveColaboradorById(@PathVariable long id){

        //Verificando se aluno com essa id existe e retornando erro caso não exista
        Optional<Aluno> o =  alunoRepository.findById(id);
        if(o.isEmpty()) throw new AlunoNotFoundException("Aluno de id " +id+ " não encontrado");

        return ResponseEntity.status(HttpStatus.OK).body(o.get());
    }

    @PostMapping
    public ResponseEntity<Aluno> colaboradorSave(@Valid @RequestBody AlunoDTO alunoDTO){

        var aluno = new Aluno(alunoDTO.name(), alunoDTO.email(), alunoDTO.cpf(), alunoDTO.curso(), alunoDTO.telefone(),
                alunoDTO.endereco());


        return ResponseEntity.status(HttpStatus.CREATED).body(alunoRepository.save(aluno));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Aluno> deleteById(@PathVariable long id){

        //Verificando se aluno com essa id existe e retornando erro caso não exista
        Optional<Aluno> o = alunoRepository.findById(id);
        if (o.isEmpty()) throw new AlunoNotFoundException("aluno de id " + id + " não encontrado");

        alunoRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PatchMapping(path = "/{id}")
    public ResponseEntity<Aluno> updateById(@PathVariable long id, @Valid @RequestBody AlunoDTO alunoDTO){

        //Verificando se aluno com essa id existe e retornando erro caso não exista
        Optional<Aluno> o = alunoRepository.findById(id);
        if (o.isEmpty()) throw new AlunoNotFoundException("Colaborador de id " + id + " não encontrado");

        Aluno c = o.get();

        //Verificando apenas os dados que podem ser alterados e os alterando caso necessário
        if (alunoDTO.email() != null && !alunoDTO.email().isEmpty()) c.setEmail(alunoDTO.email());
        if (alunoDTO.curso() != null && !alunoDTO.curso().isEmpty()) c.setCurso(Curso.fromString(alunoDTO.curso()));
        if (alunoDTO.name() != null && !alunoDTO.curso().isEmpty()) c.setName(alunoDTO.name());

        return ResponseEntity.status(HttpStatus.OK).body(alunoRepository.save(c));
    }
}
