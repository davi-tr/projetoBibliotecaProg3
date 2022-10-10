package br.edu.femass.model;

import br.edu.femass.dao.DaoAluno;

import java.util.List;

public class Leitor {
    protected Long codigo;
    protected String nome;
    protected String endereco;
    protected String telefone;

    protected List<Emprestimos> emprestimos;
    protected Integer prazoMaximoDevolucao;


    protected static Long proximoNumero = 1l;


    public static void setProximoNumero(Long proximoNumero) {
        Leitor.proximoNumero = proximoNumero;
    }

    public void atualizarID(){
        Long maior = 0L;
        try {
            List<Aluno> alunos = new DaoAluno().getAll();
            for (Aluno a : alunos) {
                if (a.getCodigo() > maior) {
                    maior = a.getCodigo();
                    setCodigo(maior + 1);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Long getCodigo() {
        return codigo;
    }


    public String getNome() {
        return nome;
    }


    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Integer getPrazoMaximoDevolucao() {
        return prazoMaximoDevolucao;
    }


}
