package daoAula;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import Mdelo.Pessoa;
import Mdelo.Usuario;

public class PessoaDaoImp implements PessoaDao {
	
	private Session session;
	  
    public void setSession(Session session) {
        this.session = session;
    }
      
    public void save(Pessoa pessoa) {
        this.session.saveOrUpdate(pessoa);
    }
    

	public List<Pessoa> listaPessoas() {
		List<Pessoa> pessoas = null;
		Criteria cri = session.createCriteria(Pessoa.class);	
		List<Pessoa> list = (List<Pessoa>) cri.list();
		pessoas = list;
		return pessoas;
	}
	
	public void delete(Pessoa pessoa){
		this.session.delete(pessoa);
	}
	
	public Pessoa findById(Pessoa pessoa){
		Criteria cri = session.createCriteria(Pessoa.class);	
		pessoa = (Pessoa) cri.list().get(0);
		return pessoa;
	}

}
