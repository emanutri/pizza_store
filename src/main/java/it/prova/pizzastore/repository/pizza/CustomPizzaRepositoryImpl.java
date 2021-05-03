package it.prova.pizzastore.repository.pizza;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.commons.lang3.StringUtils;

import it.prova.pizzastore.model.Pizza;

public class CustomPizzaRepositoryImpl implements CustomPizzaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Pizza> findByExample(Pizza example) {
		Map<String, Object> paramaterMap = new HashMap<String, Object>();
		List<String> whereClauses = new ArrayList<String>();

		StringBuilder queryBuilder = new StringBuilder(
				"Select p from Pizza p left join fetch p.ingredienti where p.id = p.id ");

		if (StringUtils.isNotEmpty(example.getDescrizione())) {
			whereClauses.add(" p.descrizione  like :descrizione ");
			paramaterMap.put("descrizione", "%" + example.getDescrizione() + "%");
		}
		if (StringUtils.isNotEmpty(example.getCodice())) {
			whereClauses.add(" p.codice  like :codice ");
			paramaterMap.put("codice", "%" + example.getCodice() + "%");
		}
		if (example.getPrezzoBase() != null) {
			whereClauses.add(" p.prezzoBase = :prezzoBase ");
			paramaterMap.put("prezzoBase", example.getPrezzoBase());
		}
		if (example.getAttivo() != null) {
			whereClauses.add(" p.attivo = :attivo ");
			paramaterMap.put("attivo", example.getAttivo());
		}
		if (example.getIngredienti() != null) {
			whereClauses.add(" p.ingredienti = :ingredienti ");
			paramaterMap.put("ingredienti", example.getIngredienti());
		}

		queryBuilder.append(!whereClauses.isEmpty() ? " and " : "");
		queryBuilder.append(StringUtils.join(whereClauses, " and "));
		TypedQuery<Pizza> typedQuery = entityManager.createQuery(queryBuilder.toString(), Pizza.class);

		for (String key : paramaterMap.keySet()) {
			typedQuery.setParameter(key, paramaterMap.get(key));
		}

		return typedQuery.getResultList();
	}
}
