package model.entities;

import model.enums.MateriasLivros;

public class Professor extends Usuario {

    public Professor(String name, int codigo, MateriasLivros materiasLivros)
    {
        super(name, codigo, materiasLivros);
    }

    @Override
    public void exibirUsuario()
    {
        System.out.println("--Área do professor---");
        System.out.println("Nome do professor: " +getName());
        System.out.println("Código do professor: " +getCodigo());
        if (getMateriasLivros() != null) {
            System.out.println("Matéria de Interesse: " + getMateriasLivros().getDescricao());
        }
        System.out.println("-------------------------");
    }
}
