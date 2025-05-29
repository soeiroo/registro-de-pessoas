package dev.soeiroo.person_registration.user;

public class PessoaJuridica extends Pessoa{
  protected String cnpj;

  public PessoaJuridica(String nome, String status, String dataNascimento, String cnpj) {
    this.nome = nome;
    this.status = status;
    this.dataNascimento = dataNascimento;
    this.cnpj = cnpj;
  }

  public String getCnpj() {
    return cnpj;
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
