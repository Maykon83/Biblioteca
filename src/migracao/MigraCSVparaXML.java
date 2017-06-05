package migracao;

import DAO.binario.LivroDao;
import java.util.HashMap;
import modelo.Livro;

public class MigraCSVparaXML {
    public static void main(String[] args) throws Exception {
		LivroDao xml_dao = new LivroDao();
		HashMap<Integer, Livro> importarLivros = xml_dao.importarLivros();
		xml_dao.salvar(importarLivros);
		
                
//                LivroDao bin_dao = new LivroDao();
//		HashMap<Integer, Livro> importarLivros = bin_dao.importarLivros();
//
//		importarLivros.forEach((id, livro) -> {
//			System.out.println(livro);
//			livro.getExemplares().forEach((cdBar, exemplar) -> System.out.println(exemplar.getExemplar()));
//		});

	}
}
