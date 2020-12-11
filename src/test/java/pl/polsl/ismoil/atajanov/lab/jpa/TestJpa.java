package pl.polsl.ismoil.atajanov.lab.jpa;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import pl.polsl.ismoil.atajanov.lab.DemoApplication;
import pl.polsl.ismoil.atajanov.lab.jpa.dao.*;
import pl.polsl.ismoil.atajanov.lab.jpa.model.*;

import java.sql.Date;
import java.time.LocalDate;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = DemoApplication.class)
public class TestJpa {

    @Autowired
    StudentJpaDao studentJpaDao;

    @Autowired
    SubjectJpaDao subjectJpaDao;

    @Autowired
    SubjectTypeJpaDao subjectTypeJpaDao;

    @Autowired
    MajorJpaDao majorJpaDao;

    @Autowired
    InstituteJpaDao instituteJpaDao;

    @Test
    public void testSubjectType(){
        final String NAME = "NEW SUBJECT TYPE";
        final String ID = "NST";
        SubjectType st = new SubjectType();
        st.setName(NAME);
        st.setId(ID);

        long sizeStart = subjectTypeJpaDao.getAll().size();
        subjectTypeJpaDao.create( st );

        Assert.assertEquals( sizeStart+1, subjectTypeJpaDao.getCount() );

        var byName = subjectTypeJpaDao.getByName( NAME ).get(0);
        var byId = subjectTypeJpaDao.getById( ID );

        Assert.assertEquals( st, byName );
        Assert.assertEquals( st, byId );

        subjectTypeJpaDao.delete( st );

        Assert.assertEquals( sizeStart, subjectTypeJpaDao.getCount() );
    }

    @Test
    public void testMajor(){
        String NAME = "NEW MAJOR NAME";
        final int INST_ID = 2;
        long sizeStartForInst = majorJpaDao.getNumberOfMajorsForInstitute( INST_ID );
        long sizeStartTotal = majorJpaDao.getAll().size();

        Major major = new Major();
        major.setMajorName(NAME);
        major.setInstitute( instituteJpaDao.getById( INST_ID ) );
        majorJpaDao.create( major );

        Assert.assertEquals( sizeStartForInst+1, majorJpaDao.getNumberOfMajorsForInstitute( INST_ID ) );
        Assert.assertEquals( sizeStartTotal+1, majorJpaDao.getCount() );

        var byName = majorJpaDao.getByName( NAME );
        var byId = majorJpaDao.getById( byName.getId() );

        Assert.assertEquals( byName, byId );
        Assert.assertTrue( majorJpaDao.getByInstituteId( INST_ID ).contains(byId) );

        majorJpaDao.delete(byId);

        Assert.assertEquals( sizeStartForInst, majorJpaDao.getNumberOfMajorsForInstitute( INST_ID ) );
        Assert.assertEquals( sizeStartTotal, majorJpaDao.getCount() );
    }

    @Test
    public void testStudent(){
        String NAME = "Ismoil Atajanov";

        Student student = new Student();
        student.setName( NAME );
        student.setGender( Gender.MALE );
        student.setDateOfBirth( Date.valueOf( LocalDate.now( )) );
        student.setMajor(majorJpaDao.getById(1));

        long sizeTotalStart = studentJpaDao.getAll().size();
        long sizeTotalMale = studentJpaDao.getNumberOfStudentsOfGender( Gender.MALE );
        long sizeTotalFemale = studentJpaDao.getNumberOfStudentsOfGender( Gender.FEMALE );
        long sizeTotalMajor = studentJpaDao.getAllFromMajor( 1 ).size();

        studentJpaDao.create( student );

        Assert.assertEquals( sizeTotalStart+1, studentJpaDao.getCount() );
        Assert.assertEquals( sizeTotalMale+1, studentJpaDao.getNumberOfStudentsOfGender( Gender.MALE ) );
        Assert.assertEquals( sizeTotalFemale, studentJpaDao.getNumberOfStudentsOfGender( Gender.FEMALE ) );
        Assert.assertEquals( sizeTotalMajor+1, studentJpaDao.getAllFromMajor( 1 ).size() );

        var byName = studentJpaDao.getByName( NAME );
        var byId = studentJpaDao.getById( byName.getId() );

        Assert.assertEquals( byName,byId );

        studentJpaDao.delete( byId );

        Assert.assertEquals( sizeTotalStart, studentJpaDao.getCount() );
        Assert.assertEquals( sizeTotalMale, studentJpaDao.getNumberOfStudentsOfGender( Gender.MALE ) );
        Assert.assertEquals( sizeTotalFemale, studentJpaDao.getNumberOfStudentsOfGender( Gender.FEMALE ) );
        Assert.assertEquals( sizeTotalMajor, studentJpaDao.getAllFromMajor( 1 ).size() );

    }

    @Test
    public void testInstitute(){
        final String NAME = "NEW INSTITUTE";
        final String NEW_NAME = "VERY NEW INSTITUTE";
        Institute institute = new Institute();
        institute.setInstituteName( NAME );

        long sizeStart = instituteJpaDao.getAll().size();

        instituteJpaDao.create( institute );

        Assert.assertEquals( sizeStart+1, instituteJpaDao.getCount() );

        var byName = instituteJpaDao.getByName( NAME );
        int id = byName.getId( );
        var byId = instituteJpaDao.getById( id );

        Assert.assertEquals( byId, byName );

        byId.setInstituteName( NEW_NAME );

        instituteJpaDao.update( byId );

        var getByIdWithNewName = instituteJpaDao.getById( id );

        Assert.assertEquals(NEW_NAME, getByIdWithNewName.getInstituteName());

        instituteJpaDao.delete( getByIdWithNewName );

        Assert.assertEquals( sizeStart, instituteJpaDao.getCount() );
    }
}
