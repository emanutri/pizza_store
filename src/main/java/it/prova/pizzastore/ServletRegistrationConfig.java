package it.prova.pizzastore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import it.prova.pizzastore.web.servlet.auth.LoginServlet;
import it.prova.pizzastore.web.servlet.pizzaiolo.ExecuteDeleteIngredienteServlet;
import it.prova.pizzastore.web.servlet.pizzaiolo.ExecuteInsertIngredienteServlet;
import it.prova.pizzastore.web.servlet.pizzaiolo.ExecuteListIngredienteServlet;
import it.prova.pizzastore.web.servlet.pizzaiolo.ExecuteModificaIngredienteServlet;
import it.prova.pizzastore.web.servlet.pizzaiolo.ExecuteSearchIngredienteServlet;
import it.prova.pizzastore.web.servlet.pizzaiolo.ExecuteVisualizzaIngredienteServlet;
import it.prova.pizzastore.web.servlet.pizzaiolo.PrepareDeleteIngredienteServlet;
import it.prova.pizzastore.web.servlet.pizzaiolo.PrepareInsertIngredienteServlet;
import it.prova.pizzastore.web.servlet.pizzaiolo.PrepareModificaIngredienteServlet;
import it.prova.pizzastore.web.servlet.pizzaiolo.PrepareSearchIngredienteServlet;
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

	// ---------------------------ingrediente-------------------------------------

	@Autowired
	private PrepareSearchIngredienteServlet prepareSearchIngredienteServlet;
	@Autowired
	private ExecuteSearchIngredienteServlet executeSearchIngredienteServlet;
	@Autowired
	private PrepareInsertIngredienteServlet prepareInsertIngredienteServlet;
	@Autowired
	private ExecuteInsertIngredienteServlet executeInsertIngredienteServlet;
	@Autowired
	private ExecuteListIngredienteServlet executeListIngredienteServlet;
	@Autowired
	private ExecuteVisualizzaIngredienteServlet executeVisualizzaIngredienteServlet;
	@Autowired
	private PrepareModificaIngredienteServlet prepareModificaIngredienteServlet;
	@Autowired
	private ExecuteModificaIngredienteServlet executeModificaIngredienteServlet;
	@Autowired
	private PrepareDeleteIngredienteServlet prepareDeleteIngredienteServlet;
	@Autowired
	private ExecuteDeleteIngredienteServlet executeDeleteIngredienteServlet;

	@Bean
	public ServletRegistrationBean<PrepareSearchIngredienteServlet> createPrepareSearchIngredienteServletBean() {
		ServletRegistrationBean<PrepareSearchIngredienteServlet> bean = new ServletRegistrationBean<PrepareSearchIngredienteServlet>(
				prepareSearchIngredienteServlet, "/pizzaiolo/PrepareSearchIngredienteServlet");
		return bean;
	}

	@Bean
	public ServletRegistrationBean<ExecuteSearchIngredienteServlet> createExecuteSearchIngredienteServletBean() {
		ServletRegistrationBean<ExecuteSearchIngredienteServlet> bean = new ServletRegistrationBean<ExecuteSearchIngredienteServlet>(
				executeSearchIngredienteServlet, "/pizzaiolo/ExecuteSearchIngredienteServlet");
		return bean;
	}

	@Bean
	public ServletRegistrationBean<PrepareInsertIngredienteServlet> createPrepareInsertIngredienteServletBean() {
		ServletRegistrationBean<PrepareInsertIngredienteServlet> bean = new ServletRegistrationBean<PrepareInsertIngredienteServlet>(
				prepareInsertIngredienteServlet, "/pizzaiolo/PrepareInsertIngredienteServlet");
		return bean;
	}

	@Bean
	public ServletRegistrationBean<ExecuteInsertIngredienteServlet> createExecuteInsertIngredienteServletBean() {
		ServletRegistrationBean<ExecuteInsertIngredienteServlet> bean = new ServletRegistrationBean<ExecuteInsertIngredienteServlet>(
				executeInsertIngredienteServlet, "/pizzaiolo/ExecuteInsertIngredienteServlet");
		return bean;
	}

	@Bean
	public ServletRegistrationBean<ExecuteListIngredienteServlet> createExecuteListIngredienteServletBean() {
		ServletRegistrationBean<ExecuteListIngredienteServlet> bean = new ServletRegistrationBean<ExecuteListIngredienteServlet>(
				executeListIngredienteServlet, "/pizzaiolo/ExecuteListIngredienteServlet");
		return bean;
	}

	@Bean
	public ServletRegistrationBean<ExecuteVisualizzaIngredienteServlet> createExecuteVisualizzaIngredienteServletBean() {
		ServletRegistrationBean<ExecuteVisualizzaIngredienteServlet> bean = new ServletRegistrationBean<ExecuteVisualizzaIngredienteServlet>(
				executeVisualizzaIngredienteServlet, "/pizzaiolo/ExecuteVisualizzaIngredienteServlet");
		return bean;
	}

	@Bean
	public ServletRegistrationBean<PrepareModificaIngredienteServlet> createPrepareModificaIngredienteServletBean() {
		ServletRegistrationBean<PrepareModificaIngredienteServlet> bean = new ServletRegistrationBean<PrepareModificaIngredienteServlet>(
				prepareModificaIngredienteServlet, "/pizzaiolo/PrepareModificaIngredienteServlet");
		return bean;
	}

	@Bean
	public ServletRegistrationBean<ExecuteModificaIngredienteServlet> createExecuteModificaIngredienteServletBean() {
		ServletRegistrationBean<ExecuteModificaIngredienteServlet> bean = new ServletRegistrationBean<ExecuteModificaIngredienteServlet>(
				executeModificaIngredienteServlet, "/pizzaiolo/ExecuteModificaIngredienteServlet");
		return bean;
	}

	@Bean
	public ServletRegistrationBean<PrepareDeleteIngredienteServlet> createPrepareDeleteIngredienteServletBean() {
		ServletRegistrationBean<PrepareDeleteIngredienteServlet> bean = new ServletRegistrationBean<PrepareDeleteIngredienteServlet>(
				prepareDeleteIngredienteServlet, "/pizzaiolo/PrepareDeleteIngredienteServlet");
		return bean;
	}

	@Bean
	public ServletRegistrationBean<ExecuteDeleteIngredienteServlet> createExecuteDeleteIngredienteServletBean() {
		ServletRegistrationBean<ExecuteDeleteIngredienteServlet> bean = new ServletRegistrationBean<ExecuteDeleteIngredienteServlet>(
				executeDeleteIngredienteServlet, "/pizzaiolo/ExecuteDeleteIngredienteServlet");
		return bean;
	}
}
