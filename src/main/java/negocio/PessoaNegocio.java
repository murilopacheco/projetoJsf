package negocio;

import java.util.List;

import Dao.utils.DAOFactory;
import Mdelo.Pessoa;
import daoAula.PessoaDao;

public class PessoaNegocio {
	
	private PessoaDao pessoaDao;
	
	public PessoaNegocio() {
		super();
		setPessoaDao(DAOFactory.createPessoa());
	}
	
	public boolean salvar(Pessoa pessoa){
		pessoaDao.save(pessoa);
		return true;
	}
	
	public List<Pessoa> listaPessoas(){
		List<Pessoa> pesssoas = null;
		pesssoas = pessoaDao.listaPessoas();
		return pesssoas;
	}
	
	public void delete(Pessoa pessoa){
		 pessoaDao.delete(pessoa);
	}
	
	public Pessoa findById(Pessoa pessoa){
		pessoa = pessoaDao.findByID(pessoa);
		return pessoa;
	}

	public PessoaDao getPessoaDao() {
		return pessoaDao;
	}

	public void setPessoaDao(PessoaDao pessoaDao) {
		this.pessoaDao = pessoaDao;
	}

	
	
}
