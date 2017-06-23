package testes;

import DAO.interfaces.AlunoDAOInterface;
import java.io.IOException;
import modelo.Aluno;

public class TestesAluno {

    AlunoDAOInterface dao;

    public TestesAluno(AlunoDAOInterface dao) {
        this.dao = dao;
    }

    public void testeCriarSalvarAluno() throws IOException {
        System.out.println("Teste cria Aluno:");
        Aluno aluno = new Aluno("2016007374", "Maykon Jimi Machado");
        System.out.println("Criando Aluno: " + aluno);
        System.out.println("Salvando..");
        dao.salvarAluno(aluno);
        System.out.println("Fim teste criaAluno. \r\n");
    }

    /**
     * Remove o aluno caso exista, Busca aluno, cria um aluno, adiciona ao
     * repositorio, busca o mesmo aluno novamente
     *
     * @throws IOException
     */
    public void testeBuscarAluno() throws IOException {
        System.out.println("Teste busca Aluno:");
        dao.removerAluno(12345);
        Aluno aluno = dao.buscarAluno(12345);
        System.out.println("Buscando aluno que não existe:");
        if (aluno != null) {
            System.out.println("Encontrou o aluno: " + aluno);
        } else {
            System.out.println("Não encontrou o aluno.");
        }
        aluno = new Aluno("0000654", "Aluno Teste", 12345);
        System.out.println("Criando Aluno: " + aluno);
        dao.salvarAluno(aluno);

        System.out.println("Buscar aluno por CD: 12345");
        aluno = dao.buscarAluno(12345);
        if (aluno != null) {
            System.out.println("Encontrou o aluno: " + aluno);
        } else {
            System.out.println("Não encontrou o aluno.");
        }

        dao.removerAluno(aluno);
        System.out.println("Fim teste busca Aluno. \r\n");
    }
}
