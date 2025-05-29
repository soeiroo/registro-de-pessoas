package dev.soeiroo.person_registration.user;

public class Pessoa {
  protected String id;
  protected String nome;
  protected String status;
  protected String dataNascimento;

  public String getNome() {return this.nome;}
  public String getStatus() {return this.status;}
  public String getDataNascimento() {return this.dataNascimento;}
  public String getId() {return this.id; }


}
