package com.app.meetupsv13.converter;

import com.app.meetupsv13.enums.Gender;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = false)
public class GenderConverter implements AttributeConverter<Gender, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Gender gender) {
        return gender != null ? gender.ordinal() : null;
    }

    @Override
    public Gender convertToEntityAttribute(Integer dbData) {
      if (dbData == null) {
        return null;
      }
		  return Gender.getGender(dbData);
    }
}
