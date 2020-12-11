package pl.polsl.ismoil.atajanov.lab.jpa.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.List;

public abstract class JpaDaoBase<T extends Serializable, U> {

    private EntityManager em;

    public void setEmf( EntityManagerFactory emf ) {
        em = emf.createEntityManager( );
    }

    protected EntityManager getEm() {
        return em;
    }

    public void create( T entity ) {
        em.getTransaction( ).begin( );
        em.persist( entity );
        em.getTransaction( ).commit( );
    }

    public T getById( U id ) {
        return em.find( getEntityClass( ), id );
    }

    public List<T> getAll() {
        CriteriaBuilder builder = em.getCriteriaBuilder( );
        CriteriaQuery query = builder.createQuery( );
        Root<T> root = query.from( getEntityClass( ) );

        query.select( root );
        return em.createQuery( query ).getResultList( );
    }

    public void delete( T entity ) {
        try {
            em.getTransaction( ).begin( );
            em.remove( em.contains( entity ) ? entity : em.merge( entity ) );
            em.getTransaction( ).commit( );
        } catch ( Exception e ) {
            e.printStackTrace( );
            em.getTransaction( ).rollback( );
        }
    }

    public void delete( U id ) {
        delete( getById( id ) );
    }

    public void update( T entity ) {
        try {
            em.getTransaction( ).begin( );
            em.merge( entity );
            em.getTransaction( ).commit( );
        } catch ( Exception e ) {
            em.getTransaction( ).rollback( );
        }
    }

    public long getCount() {
        CriteriaBuilder builder = em.getCriteriaBuilder( );
        CriteriaQuery query = builder.createQuery( );
        Root<T> root = query.from( getEntityClass( ) );

        query.select(
                builder.count( root )
        );
        return ( Long ) em.createQuery( query ).getSingleResult( );
    }

    protected abstract Class<T> getEntityClass();
}
