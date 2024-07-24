package com.app.meetupsv13.converter;

import com.app.meetupsv13.enums.Currency;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = false)
public class CurrencyConverter implements AttributeConverter<Currency, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Currency currency) {
        return currency != null ? currency.ordinal() : null;
    }

    @Override
    public Currency convertToEntityAttribute(Integer dbData) {
      if (dbData == null) {
        return null;
      }
		  return Currency.getCurrency(dbData);
    }
}
