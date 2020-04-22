package pe.com.claro.common.domain.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;



public abstract class AbstractRepository<T>
{


   // ======================================
   // =             Attributes             =
   // ======================================
   protected EntityManager entityManager;

   private Class<T> entityClass;

   // ======================================
   // =            Constructors            =
   // ======================================

   public AbstractRepository()
   {
   }

   public AbstractRepository(Class<T> entityClass)
   {
      this.entityClass = entityClass;
   }

   // ======================================
   // =          Business methods          =
   // ======================================

   public T persist(T entity)
   {
      entityManager.persist(entity);
      return entity;
   }

   public T findById(Long id)
   {
      return entityManager.find(entityClass, id);
   }

   public void remove(T entity)
   {
      entityManager.remove(entityManager.merge(entity));
   }

   public T merge(T entity)
   {
      return entityManager.merge(entity);
   }

   public List<T> listAll(Integer startPosition, Integer maxResult)
   {
      TypedQuery<T> findAllQuery = getListAllQuery();
      if (startPosition != null)
{
         findAllQuery.setFirstResult(startPosition);
      }
      if (maxResult != null)
      {
         findAllQuery.setMaxResults(maxResult);
      }
      return findAllQuery.getResultList();
   }

   public List<T> listAll()
   {
      return getListAllQuery().getResultList();
   }

   public TypedQuery<T> getListAllQuery()
   {
      CriteriaQuery<T> criteria = entityManager.getCriteriaBuilder().createQuery(entityClass);
      return entityManager.createQuery(criteria.select(criteria.from(entityClass)));
   }

   public long count(T example)
   {

      CriteriaBuilder builder = entityManager.getCriteriaBuilder();

      // Populate count

      CriteriaQuery<Long> countCriteria = builder.createQuery(Long.class);
      Root<T> root = countCriteria.from(entityClass);
      countCriteria = countCriteria.select(builder.count(root)).where(getSearchPredicates(root, example));
      return entityManager.createQuery(countCriteria).getSingleResult();
   }

   public List<T> page(T example, int page, int pageSize)
   {

      CriteriaBuilder builder = entityManager.getCriteriaBuilder();

      // Populate pageItems

      CriteriaQuery<T> criteria = builder.createQuery(entityClass);
      Root<T> root = criteria.from(entityClass);
      TypedQuery<T> query = entityManager.createQuery(criteria.select(root).where(getSearchPredicates(root, example)));
      query.setFirstResult(page * pageSize).setMaxResults(pageSize);
      return query.getResultList();

   }

   public StoredProcedureQuery createProcedureQuery(String procedureName) {
		clear();
		return entityManager.createStoredProcedureQuery(procedureName);
	}

	private void clear() {
		entityManager.clear();
	}
	
   // ======================================
   // =         Protected methods          =
   // ======================================

   protected abstract Predicate[] getSearchPredicates(Root<T> root, T example);
}