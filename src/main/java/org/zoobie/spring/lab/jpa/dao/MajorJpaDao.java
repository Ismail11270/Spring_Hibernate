package org.zoobie.spring.lab.jpa.dao;

import org.springframework.stereotype.Component;
import org.zoobie.spring.lab.jpa.model.Major;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;


@Component
public class MajorJpaDao extends JpaDaoBase<Major, Integer> {


    public Major getByName( String name ) {
        TypedQuery<Major> query = getEm( ).createQuery( "SELECT m FROM Major m WHERE m.majorName=:name", Major.class );
        query.setParameter( "name", name );
        return query.getSingleResult( );
    }

    public List<Major> getByInstituteId( int id ) {
        TypedQuery<Major> query = getEm( ).createQuery( "SELECT m FROM Major m WHERE m.institute.id=:id", Major.class );
        query.setParameter( "id", id );
        return query.getResultList( );
    }

    public long getNumberOfMajorsForInstitute( int instituteId ) {
        CriteriaBuilder builder = getEm().getCriteriaBuilder( );
        CriteriaQuery query = builder.createQuery( );
        Root<Major> root = query.from( Major.class );
        query.select(
                builder.count( root )
        ).where( builder.equal( root.get("institute"),instituteId ));
        return ( Long ) getEm().createQuery( query ).getSingleResult( );
    }

    @Override
    protected Class<Major> getEntityClass() {
        return Major.class;
    }
}
