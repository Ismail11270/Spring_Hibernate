package pl.polsl.ismoil.atajanov.lab.jpa.dao;

import pl.polsl.ismoil.atajanov.lab.jpa.model.Institute;

import javax.persistence.TypedQuery;

public class InstituteJpaDao extends JpaDaoBase<Institute,Integer> {

    public Institute getByName( String name){
        TypedQuery<Institute> query = getEm().createQuery("SELECT i FROM Institute i WHERE i.instituteName=:name", Institute.class);
        query.setParameter("name",name );
        return query.getSingleResult();
    }

    @Override
    protected Class<Institute> getEntityClass() {
        return Institute.class;
    }
}
