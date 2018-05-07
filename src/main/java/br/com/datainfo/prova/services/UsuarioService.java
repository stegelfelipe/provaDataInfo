package br.com.datainfo.prova.services;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.datainfo.prova.entity.Funcao;
import br.com.datainfo.prova.entity.Usuario;
import br.com.datainfo.prova.infra.HibernateUtil;
import br.com.datainfo.prova.pagination.PaginatedListWrapper;

public class UsuarioService {

	public String inserir(Usuario usuario) {
		usuario.setCpf(usuario.getCpf());
		usuario.setNomeUsuario(usuario.getNomeUsuario());
		usuario.setEmail(usuario.getEmail());
		usuario.setSituacao(usuario.getSituacao());
		usuario.setPerfil(usuario.getPerfil());
		usuario.setFuncao(usuario.getFuncao());
		usuario.setTelefone(usuario.getTelefone());

		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction t = s.beginTransaction();
		s.save(usuario);
		t.commit();
		return usuario.getCpf();
	}

	public void alterar(Usuario usuario) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction t = s.beginTransaction();
		s.merge(usuario);
		t.commit();
	}

	public void excluir(String cpf) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		Usuario c = selecionar(cpf);

		Transaction t = s.beginTransaction();
		s.delete(c);
		t.commit();
	}

	public Usuario selecionar(String cpf) {
		return (Usuario) HibernateUtil.getSessionFactory().openSession().get(Usuario.class, cpf);
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> listar() {
		return (List<Usuario>) HibernateUtil.getSessionFactory().openSession().createQuery("from Usuario")
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Funcao> listaFuncoes() {
		return (List<Funcao>) HibernateUtil.getSessionFactory().openSession().createQuery("from Funcao")
				.getResultList();
	}

	public Integer countUsuarios() {
		return ((Long) HibernateUtil.getSessionFactory().openSession().createQuery("SELECT COUNT(u.cpf) FROM Usuario u")
				.getSingleResult()).intValue();

	}

	@SuppressWarnings("unchecked")
	public List<Usuario> findUsuarios(int startPosition, int maxResults, String sortFields, String sortDirections) {
		return (List<Usuario>) HibernateUtil.getSessionFactory().openSession().createQuery("SELECT p FROM Person p ORDER BY " + sortFields + " " + sortDirections)
				.setFirstResult(startPosition)
                .setMaxResults(maxResults)
				.getResultList();
		
    }
	
	
}
