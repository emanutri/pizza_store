package it.prova.pizzastore.repository.ingrediente;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.commons.lang3.StringUtils;

import it.prova.pizzastore.model.Ingrediente;

public class CustomIngredienteRepositoryImpl implements CustomIngredienteRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Ingrediente> findByExample(Ingrediente example) {
		Map<String, Object> paramaterMap = new HashMap<String, Object>();
		List<String> whereClauses = new ArrayList<String>();

		StringBuilder queryBuilder = new StringBuilder("select i from Ingrediente i where i.id = i.id ");

		if (StringUtils.isNotEmpty(example.getDescrizione())) {
			whereClauses.add(" i.descrizione  like :descrizione ");
			paramaterMap.put("descrizione", "%" + example.getDescrizione() + "%");
		}
		if (example.getPrezzo() != null) {
			whereClauses.add(" i.prezzo = :prezzo ");
			paramaterMap.put("prezzo", example.getPrezzo());
		}
		if (StringUtils.isNotEmpty(example.getCodice())) {
			whereClauses.add(" i.codice like :codice ");
			paramaterMap.put("codice", "%" + example.getCodice() + "%");
		}

		queryBuilder.append(!whereClauses.isEmpty() ? " and " : "");
		queryBuilder.append(StringUtils.join(whereClauses, " and "));
		TypedQuery<Ingrediente> typedQuery = entityManager.createQuery(queryBuilder.toString(), Ingrediente.class);

		for (String key : paramaterMap.keySet()) {
			typedQuery.setParameter(key, paramaterMap.get(key));
		}

		return typedQuery.getResultList();
	}

}
