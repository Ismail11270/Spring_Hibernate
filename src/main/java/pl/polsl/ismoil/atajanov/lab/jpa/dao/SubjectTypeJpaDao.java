package pl.polsl.ismoil.atajanov.lab.jpa.dao;

import org.springframework.stereotype.Component;
import pl.polsl.ismoil.atajanov.lab.jpa.model.SubjectType;

import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class SubjectTypeJpaDao extends JpaDaoBase<SubjectType,String> {

    public List<SubjectType> getByName( String name){
        TypedQuery<SubjectType> query = getEm().createQuery("SELECT s FROM SubjectType s WHERE s.name=:name", SubjectType.class);
        query.setParameter("name",name );
        return query.getResultList();
    }

    @Override
    protected Class<SubjectType> getEntityClass() {
        return SubjectType.class;
    }
}
