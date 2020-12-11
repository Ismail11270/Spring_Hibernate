package pl.polsl.ismoil.atajanov.lab.jpa.dao;

import org.springframework.stereotype.Component;
import pl.polsl.ismoil.atajanov.lab.jpa.model.Gender;
import pl.polsl.ismoil.atajanov.lab.jpa.model.Student;

import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class StudentJpaDao extends JpaDaoBase<Student,Integer> {

    public Student getByName( String name){
        TypedQuery<Student> query = getEm().createQuery("SELECT s FROM Student s WHERE s.name=:name", Student.class);
        query.setParameter("name",name );
        return query.getSingleResult();
    }

    public List<Student> getAllFromMajor(int majorId){
        TypedQuery<Student> query = getEm().createQuery( "SELECT s FROM Student s WHERE s.major.id=:id", Student.class );
        query.setParameter( "id", majorId );
        return query.getResultList();
    }

    public long getNumberOfStudentsOfGender( Gender gender ){
        TypedQuery<Long> query = getEm().createQuery( "SELECT count(s) FROM Student s WHERE s.gender=:gender", Long.class );
        query.setParameter( "gender", gender );
        return query.getSingleResult();
    }

    @Override
    protected Class<Student> getEntityClass() {
        return Student.class;
    }
}
