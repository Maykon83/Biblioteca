package testes;

import DAO.interfaces.EmprestimoDAOInterface;
import java.io.IOException;
import java.time.LocalDate;
import modelo.Aluno;
import modelo.Emprestimo;
import modelo.Livro;

public class TestesEmprestimo {

    EmprestimoDAOInterface dao;

    public TestesEmprestimo(EmprestimoDAOInterface dao) {
        this.dao = dao;
    }

    public void testeCriarEmprestimo() throws Exception {
        System.out.println("Teste criarEmprestimo");

        Livro livro = new Livro(0, 0, 0, LocalDate.MAX, LocalDate.MIN, "clas", "area", "autores", "titulo", "1990", "123456", "123", 0);
        System.out.println("Criando Livro: " + livro);
        Aluno aluno = new Aluno("123", "Maykon Jimi Machado");
        System.out.println("Criando Aluno: " + aluno);
        Emprestimo emprestimo = new Emprestimo(aluno, livro, LocalDate.now(), 123);
        System.out.println("Criando emprestimo: " + emprestimo);

        dao.salvarEmprestimo(emprestimo);
        System.out.println("Salvo no Repositorio com sucesso.");
        System.out.println("Fim teste criarEmprestimo. \r\n");
    }

    public void testeBuscaEmprestimo() throws IOException, Exception {
        System.out.println("Teste busca Emprestimo");

        dao.removerEmprestimo(2016007374);
        Emprestimo emprestimo = dao.buscarEmprestimo(2016007374);
        System.out.println("Buscando emprestimo que não existe:");
        if (emprestimo != null) {
            System.out.println("Encontrou o emprestimo: " + emprestimo);
        } else {
            System.out.println("Não encontrou o emprestimo.");
        }

        Livro livro = new Livro(0, 0, 0, LocalDate.MAX, LocalDate.MIN, "clas", "area", "autores", "titulo", "1990", "123456", "123", 0);

        Aluno aluno = new Aluno("123", "Maykon Jimi Machado");

        emprestimo = new Emprestimo(aluno, livro, LocalDate.now(), 2016007374);

        System.out.println("Criando Emprestimo: " + emprestimo);
        dao.salvarEmprestimo(emprestimo);

        System.out.println("Buscar emprestimo por ID: 2016007374");
        emprestimo = dao.buscarEmprestimo(2016007374);
        if (emprestimo != null) {
            System.out.println("Encontrou o emprestimo: " + emprestimo);
        } else {
            System.out.println("Não encontrou o emprestimo.");
        }

//        dao.removerEmprestimo(emprestimo);
        System.out.println("Fim teste busca Emprestimo. \r\n");
    }
}
