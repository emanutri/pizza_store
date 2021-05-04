package it.prova.pizzastore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import it.prova.pizzastore.web.servlet.auth.LoginServlet;
import it.prova.pizzastore.web.servlet.registration.PrepareRegistrationServlet;
import it.prova.pizzastore.web.servlet.registration.RegistrationServlet;
import it.prova.pizzastore.web.servlet.utente.ExecuteSearchUtenteServlet;
import it.prova.pizzastore.web.servlet.utente.PrepareSearchUtenteServlet;

@Configuration
public class ServletRegistrationConfig {

	@Autowired
	private LoginServlet loginServlet;
	@Autowired
	private PrepareRegistrationServlet prepareRegistrationServlet;
	@Autowired
	private RegistrationServlet registrationServlet;
	
	@Bean
	public ServletRegistrationBean<LoginServlet> createLoginServletBean() {
		ServletRegistrationBean<LoginServlet> bean = new ServletRegistrationBean<LoginServlet>(loginServlet,
				"/LoginServlet");
		return bean;
	}

	@Bean
	public ServletRegistrationBean<PrepareRegistrationServlet> createPrepareRegistrationServletBean() {
		ServletRegistrationBean<PrepareRegistrationServlet> bean = new ServletRegistrationBean<PrepareRegistrationServlet>(
				prepareRegistrationServlet, "/registration/PrepareRegistrationServlet");
		return bean;
	}

	@Bean
	public ServletRegistrationBean<RegistrationServlet> createRegistrationServletBean() {
		ServletRegistrationBean<RegistrationServlet> bean = new ServletRegistrationBean<RegistrationServlet>(
				registrationServlet, "/registration/RegistrationServlet");
		return bean;
	}
	
	//-----------------------utente------------------------------
	
		@Autowired
		private PrepareSearchUtenteServlet prepareSearchUtenteServlet;
		@Autowired
		private ExecuteSearchUtenteServlet executeSearchUtenteServlet;
		
		@Bean
		public ServletRegistrationBean<PrepareSearchUtenteServlet> createPrepareSearchUtenteServletBean() {
			ServletRegistrationBean<PrepareSearchUtenteServlet> bean = new ServletRegistrationBean<PrepareSearchUtenteServlet>(
					prepareSearchUtenteServlet, "/utente/PrepareSearchUtenteServlet");
			return bean;
		}

		@Bean
		public ServletRegistrationBean<ExecuteSearchUtenteServlet> createExecuteSearchUtenteServletBean() {
			ServletRegistrationBean<ExecuteSearchUtenteServlet> bean = new ServletRegistrationBean<ExecuteSearchUtenteServlet>(
					executeSearchUtenteServlet, "/utente/ExecuteSearchUtenteServlet");
			return bean;
		}
	
}
