package dev.soeiroo.person_registration.user;

public class PessoaFisica extends Pessoa {
  protected String cpf;

  public PessoaFisica(String nome, String status, String dataNascimento, String cpf) {
    this.nome = nome;
    this.status = status;
    this.dataNascimento = dataNascimento;
    this.cpf = cpf;
  }

  public String getCpf() {
    return cpf;
  }

  public String getStatus() {
    return status;
  }
  public String getDataNascimento() {
    return dataNascimento;
  }
  public String getNome() {
    return nome;
  }

}