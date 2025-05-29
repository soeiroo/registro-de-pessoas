package dev.soeiroo.person_registration.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {

  private final PessoaRepository pessoaRepository;

  public PessoaController(PessoaRepository pessoaRepository) {
    this.pessoaRepository = pessoaRepository;
  }

  @GetMapping ("")
  List<Pessoa> getPessoas() {
    return pessoaRepository.getPessoas();
  }

  @GetMapping ("/pessoasFisicas")
  List<PessoaFisica> getPessoasFisicas() {
    Optional<List<PessoaFisica>> pessoas_fisicas = pessoaRepository.getPessoasFisicas();
    if (pessoas_fisicas.isEmpty()) {
      throw new RuntimeException("Nenhuma pessoa física encontrada.");
    }
    return pessoas_fisicas.get();
  }

  @GetMapping ("/pessoasJuridicas")
  List<PessoaJuridica> getPessoasJuridicas() {
    Optional<List<PessoaJuridica>> pessoas_juridicas = pessoaRepository.getPessoasJuridicas();
    if (pessoas_juridicas.isEmpty()) {
      throw new RuntimeException("Nenhuma pessoa jurídica encontrada.");
    }
    return pessoas_juridicas.get();
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping ("/pessoasFisicas")
  void addPessoaFisica(@RequestBody PessoaFisica pessoa) {
    pessoaRepository.addPessoaFisica(pessoa);
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping("/pessoasJuridicas")
  void addPessoaJuridica(@RequestBody PessoaJuridica pessoa) {
    pessoaRepository.addPessoaJuridica(pessoa);
  }

  @GetMapping("/pessoasFisicas/{cpf}")
  PessoaFisica findByCpf(@PathVariable String cpf) {
    PessoaFisica pessoa = pessoaRepository.findByCpf(cpf);
    if (pessoa == null) {
      throw new RuntimeException("Pessoa física com CPF " + cpf + " não encontrada.");
    }
    return pessoa;
  }

  @GetMapping("/pessoasJuridicas/{cnpj}")
  PessoaJuridica findByCnpj(@PathVariable String cnpj) {
    PessoaJuridica pessoa = pessoaRepository.findByCnpj(cnpj);
    if (pessoa == null) {
      throw new RuntimeException("Pessoa jurídica com CNPJ " + cnpj + " não encontrada.");
    }
    return pessoa;
  }
}
