package DAO.xml;

import java.io.IOException;
import java.util.HashMap;

public class Emprestimo_DAO extends DAO_XML_Generico {
    private String endereco = System.getProperty("user.home") + System.getProperty("file.separator")
			+ "emprestimos.xml";

	@Override
	public HashMap<Long, Emprestimo_DAO> ler() throws IOException, Exception {
		return carregarArquivo(endereco);
	}

	@Override
	public <Long, Emprestimo> void salvar(HashMap<Long, Emprestimo> map) throws IOException, Exception {
		salvarArquivo(map, endereco);
	}

    
}
