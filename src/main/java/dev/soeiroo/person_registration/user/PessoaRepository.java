package dev.soeiroo.person_registration.user;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

@Repository
public class PessoaRepository {

  private List<PessoaFisica> pessoasFisicas = new ArrayList<>();
  private List<PessoaJuridica> pessoasJuridicas = new ArrayList<>();

  List<Pessoa> getPessoas() {
    List<Pessoa> pessoas = new ArrayList<>();
    pessoas.addAll(pessoasFisicas);
    pessoas.addAll(pessoasJuridicas);
    return pessoas;
  }

  Optional<List<PessoaFisica>> getPessoasFisicas() {
    return pessoasFisicas.isEmpty() ? Optional.empty() : Optional.of(pessoasFisicas);
  }

  Optional<List<PessoaJuridica>> getPessoasJuridicas() {
    return pessoasJuridicas.isEmpty() ? Optional.empty() : Optional.of(pessoasJuridicas);
  }

  void addPessoaFisica(PessoaFisica pessoa) {
    if (pessoa != null && "PF".equals(pessoa.getStatus())) {
      pessoasFisicas.add(pessoa);
    } else {
      throw new IllegalArgumentException("Pessoa inválida ou não é uma pessoa física.");
    }
  }

  void addPessoaJuridica(PessoaJuridica pessoa) {
    if (pessoa != null && "PJ".equals(pessoa.getStatus())){
      pessoasJuridicas.add(pessoa);
    } else {
      throw new IllegalArgumentException("Pessoa inválida ou não é uma pessoa jurídica.");
    }
  }

  void removePessoaFisica(PessoaFisica pessoa) {
    if (pessoa != null && pessoasFisicas.contains(pessoa)) {
      pessoasFisicas.remove(pessoa);
    } else {
      throw new IllegalArgumentException("Pessoa física inválida ou não encontrada.");
    }
  }

  PessoaFisica findByCpf(String cpf) {
    for (PessoaFisica pessoa : pessoasFisicas) {
      if (pessoa.getCpf().equals(cpf)) {
        return pessoa;
      }
    }
    throw new IllegalArgumentException("Pessoa física com CPF " + cpf + " não encontrada.");
  }

  PessoaJuridica findByCnpj(String cnpj) {
    for (PessoaJuridica pessoa : pessoasJuridicas) {
      if (pessoa.getCnpj().equals(cnpj)) {
        return pessoa;
      }
    }
    throw new IllegalArgumentException("Pessoa jurídica com CNPJ " + cnpj + " não encontrada.");
  }


  @PostConstruct
  private void init() {
    pessoasFisicas.add(new PessoaFisica("João", "PF", "01/01/1990", "12345678900"));
    pessoasJuridicas.add(new PessoaJuridica("Empresa X", "PJ", "01/01/2000", "12345678000195"));
  }
}
