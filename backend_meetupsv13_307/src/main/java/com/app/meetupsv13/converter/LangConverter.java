package com.app.meetupsv13.converter;

import com.app.meetupsv13.enums.Lang;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = false)
public class LangConverter implements AttributeConverter<Lang, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Lang lang) {
        return lang != null ? lang.ordinal() : null;
    }

    @Override
    public Lang convertToEntityAttribute(Integer dbData) {
      if (dbData == null) {
        return null;
      }
		  return Lang.getLang(dbData);
    }
}
