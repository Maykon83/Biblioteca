package DAO.binario;

import java.io.IOException;
import java.util.HashMap;

public class Emprestimo_DAO extends DAO_Binario_Generico {
    
    private String endereco = System.getProperty("user.home") + System.getProperty("file.separator")
			+ "emprestimos.bin";

	@Override
	public HashMap<Long, Emprestimo_DAO> ler() throws IOException {
		return carregarArquivo(endereco);
	}

	@Override
	public <Long, Emprestimo> void salvar(HashMap<Long, Emprestimo> map) throws IOException {
		salvarArquivo(map, endereco);
	}

    public void emprestar_Livro() {
        //data atual(hoje) + dias de empréstimo

    }

    public void devolver_Livro() {
        //data da devolução - data do empréstimo
    }

}