package org.zoobie.spring.lab.converter;

import org.zoobie.spring.lab.first.two.model.Gender;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class GenderConverter implements AttributeConverter<Gender, Character> {

    @Override
    public Character convertToDatabaseColumn( Gender gender ) {
        return gender.getGenderChar();
    }

    @Override
    public Gender convertToEntityAttribute( Character gender ) {
        return Gender.getGenderFromChar( gender );
    }
}
