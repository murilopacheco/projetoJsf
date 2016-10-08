package daoAula;

import Mdelo.Pessoa;
import Mdelo.Usuario;
import java.util.List;

public interface PessoaDao {

	 public void save(Pessoa pessoa);
	 
	 public default List<Pessoa> listaPessoas(){
		 PessoaDaoImp pessoaDaoImp = new PessoaDaoImp();
		 List<Pessoa> pessoas = pessoaDaoImp.listaPessoas();
		 return pessoas;
	 }
	 
	 public void delete(Pessoa pessoa);
	 
	 public default Pessoa findByID(Pessoa pessoa){
		 
		 return pessoa;
	 }
}
