package model.entities;

import model.enums.MateriasLivros;

import java.util.ArrayList;
import java.util.List;

public class Aluno extends Usuario
{
    public Aluno(String name, int  codigo, MateriasLivros materiasLivros) {
        super(name, codigo, materiasLivros);
    }

    @Override
    public void exibirUsuario()
    {
        System.out.println("--- Detalhes do Aluno ---");
        System.out.println("Nome: " + getName());
        System.out.println("Código: " + getCodigo());
        if (getMateriasLivros() != null) {
            System.out.println("Matéria de Interesse: " + getMateriasLivros().getDescricao());
        }
        System.out.println("-------------------------");
    }
}
