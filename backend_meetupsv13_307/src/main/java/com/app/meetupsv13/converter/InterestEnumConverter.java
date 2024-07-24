package com.app.meetupsv13.converter;

import com.app.meetupsv13.enums.InterestEnum;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = false)
public class InterestEnumConverter implements AttributeConverter<InterestEnum, Integer> {

    @Override
    public Integer convertToDatabaseColumn(InterestEnum interestEnum) {
        return interestEnum != null ? interestEnum.ordinal() : null;
    }

    @Override
    public InterestEnum convertToEntityAttribute(Integer dbData) {
      if (dbData == null) {
        return null;
      }
		  return InterestEnum.getInterestEnum(dbData);
    }
}
