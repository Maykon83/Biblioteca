package DAO.binario;

import java.io.IOException;
import java.util.HashMap;
import modelo.Emprestimo;
import DAO.interfaces.EmprestimoDAOInterface;

public class Emprestimo_DAO extends DAO_Binario_Generico implements EmprestimoDAOInterface {

    private final String endereco = System.getProperty("C:\\Users\\Maykon\\Documents\\NetBeansProjects\\Nova_Biblioteca") + System.getProperty("\\Emprestimo.bin")
            + "Emprestimos.bin";

    @Override
    public HashMap<Long, Emprestimo> ler() throws IOException {
        return carregarArquivo(endereco);
    }

    @Override
    public <Long, Emprestimo> void salvar(HashMap<Long, Emprestimo> map) throws IOException {
        salvarArquivo(map, endereco);
    }

    @Override
    public Emprestimo buscarEmprestimo(long cdEmprestimo) throws IOException {
        HashMap<Long, Emprestimo> emprestimos = ler();
        return emprestimos.get(cdEmprestimo);
    }

    @Override
    public void salvarEmprestimo(Emprestimo emprestimo) throws IOException {
        HashMap<Long, Emprestimo> emprestimos = ler();
        emprestimos.put(emprestimo.getCdEmprestimo(), emprestimo);
        salvar(emprestimos);
    }

    @Override
    public void removerEmprestimo(Emprestimo emprestimo) throws IOException {
        HashMap<Long, Emprestimo> emprestimos = ler();
        emprestimos.remove(emprestimo.getCdEmprestimo());
        salvar(emprestimos);
    }

    @Override
    public void removerEmprestimo(long cdEmprestimo) throws IOException {
        HashMap<Long, Emprestimo> emprestimos = ler();
        emprestimos.remove(cdEmprestimo);
        salvar(emprestimos);
    }
}
