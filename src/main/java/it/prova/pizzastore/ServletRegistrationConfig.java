package it.prova.pizzastore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import it.prova.pizzastore.web.servlet.auth.LoginServlet;
import it.prova.pizzastore.web.servlet.registration.PrepareRegistrationServlet;
import it.prova.pizzastore.web.servlet.registration.RegistrationServlet;
import it.prova.pizzastore.web.servlet.utente.ExecuteCambiaStatoUtenteServlet;
import it.prova.pizzastore.web.servlet.utente.ExecuteInsertUtenteServlet;
import it.prova.pizzastore.web.servlet.utente.ExecuteListUtenteServlet;
import it.prova.pizzastore.web.servlet.utente.ExecuteModificaUtenteServlet;
import it.prova.pizzastore.web.servlet.utente.ExecuteSearchUtenteServlet;
import it.prova.pizzastore.web.servlet.utente.ExecuteVisualizzaUtenteServlet;
import it.prova.pizzastore.web.servlet.utente.PrepareInsertUtenteServlet;
import it.prova.pizzastore.web.servlet.utente.PrepareModificaUtenteServlet;
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

	// -----------------------utente------------------------------
	
	@Autowired
	private PrepareSearchUtenteServlet prepareSearchUtenteServlet;
	@Autowired
	private ExecuteSearchUtenteServlet executeSearchUtenteServlet;
	@Autowired
	private ExecuteVisualizzaUtenteServlet executeVisualizzaUtenteServlet;
	@Autowired
	private ExecuteListUtenteServlet executeListUtenteServlet;
	@Autowired
	private PrepareInsertUtenteServlet prepareInsertUtenteServlet;
	@Autowired
	private ExecuteInsertUtenteServlet executeInsertUtenteServlet;
	@Autowired
	private PrepareModificaUtenteServlet prepareModificaUtenteServlet;
	@Autowired
	private ExecuteModificaUtenteServlet executeModificaUtenteServlet;
	@Autowired
	private ExecuteCambiaStatoUtenteServlet executeCambiaStatoUtenteServlet;

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

	@Bean
	public ServletRegistrationBean<ExecuteVisualizzaUtenteServlet> createExecuteVisualizzaUtenteServletBean() {
		ServletRegistrationBean<ExecuteVisualizzaUtenteServlet> bean = new ServletRegistrationBean<ExecuteVisualizzaUtenteServlet>(
				executeVisualizzaUtenteServlet, "/utente/ExecuteVisualizzaUtenteServlet");
		return bean;
	}

	@Bean
	public ServletRegistrationBean<ExecuteListUtenteServlet> createExecuteListUtenteServletBean() {
		ServletRegistrationBean<ExecuteListUtenteServlet> bean = new ServletRegistrationBean<ExecuteListUtenteServlet>(
				executeListUtenteServlet, "/utente/ExecuteListUtenteServlet");
		return bean;
	}

	@Bean
	public ServletRegistrationBean<PrepareInsertUtenteServlet> createPrepareInsertUtenteServletBean() {
		ServletRegistrationBean<PrepareInsertUtenteServlet> bean = new ServletRegistrationBean<PrepareInsertUtenteServlet>(
				prepareInsertUtenteServlet, "/utente/PrepareInsertUtenteServlet");
		return bean;
	}

	@Bean
	public ServletRegistrationBean<ExecuteInsertUtenteServlet> createExecuteInsertUtenteServletBean() {
		ServletRegistrationBean<ExecuteInsertUtenteServlet> bean = new ServletRegistrationBean<ExecuteInsertUtenteServlet>(
				executeInsertUtenteServlet, "/utente/ExecuteInsertUtenteServlet");
		return bean;
	}
	
	@Bean
	public ServletRegistrationBean<PrepareModificaUtenteServlet> createPrepareModificaUtenteServletBean() {
		ServletRegistrationBean<PrepareModificaUtenteServlet> bean = new ServletRegistrationBean<PrepareModificaUtenteServlet>(
				prepareModificaUtenteServlet, "/utente/PrepareModificaUtenteServlet");
		return bean;
	}
	
	@Bean
	public ServletRegistrationBean<ExecuteModificaUtenteServlet> createExecuteModificaUtenteServletBean() {
		ServletRegistrationBean<ExecuteModificaUtenteServlet> bean = new ServletRegistrationBean<ExecuteModificaUtenteServlet>(
				executeModificaUtenteServlet, "/utente/ExecuteModificaUtenteServlet");
		return bean;
	}
	
	@Bean
	public ServletRegistrationBean<ExecuteCambiaStatoUtenteServlet> createExecuteCambiaStatoUtenteServletBean() {
		ServletRegistrationBean<ExecuteCambiaStatoUtenteServlet> bean = new ServletRegistrationBean<ExecuteCambiaStatoUtenteServlet>(
				executeCambiaStatoUtenteServlet, "/utente/ExecuteCambiaStatoUtenteServlet");
		return bean;
	}
}
