package Filtro;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Mdelo.Usuario;


/**
 * @author murilo
 * Não se esquecer de permitir acesso as páginas aos usuários com a deivida permissão.
 *
 */
@WebFilter(urlPatterns = { "/public/usuario.jsf", "/public/usuario.xhtml", "/public/pedido.jsf", "/public/index.jsf" })
public class Filtro implements Filter {

	public List<String> enderecosUsuarioComum = new ArrayList<String>();

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		Usuario user = null;
		boolean permitido = false;
		HttpSession sess = ((HttpServletRequest) request).getSession(false);

		if (sess != null) {
			user = (Usuario) sess.getAttribute("usuario");
		}

		if (user == null) {
			String navegacao = "/public/login.jsf";
			String contextPath = ((HttpServletRequest) request).getContextPath();
			((HttpServletResponse) response).sendRedirect(contextPath + navegacao);
		} else {

			if (user.getId_perfil() == 1) {
				chain.doFilter(request, response);
			} else {
				String contextRequest = ((HttpServletRequest) request).getRequestURI();
				enderecosUsuarioComum = this.ListaAcessoUsuarioComum(request, response);
				for (int i = 0; i < enderecosUsuarioComum.size(); i++) {
					String endereco = enderecosUsuarioComum.get(i);
					if (contextRequest.equals(endereco)) {
						permitido = true;
						break;

					} else {
						permitido = false;
					}

				}
				if (permitido) {
					chain.doFilter(request, response);
				} else {
					String path = ((HttpServletRequest) request).getContextPath();
					((HttpServletResponse) response).sendRedirect(path + "/public/acessoNegado.jsf");
				}
			}

		}
		enderecosUsuarioComum = new ArrayList<>();
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

	public List<String> ListaAcessoUsuarioComum(ServletRequest request, ServletResponse response) throws IOException {
		String path = ((HttpServletRequest) request).getContextPath();
		enderecosUsuarioComum.add(path + "/public/index.jsf");
		enderecosUsuarioComum.add(path + "/public/usuario.jsf");

		return enderecosUsuarioComum;
	}

}
