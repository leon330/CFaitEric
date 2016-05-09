package model.commons;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class LocalDateConverter implements AttributeConverter<LocalDate, Date> {

	@Override
	public Date convertToDatabaseColumn(final LocalDate localDate) {
		final Date result;
		if (localDate == null) {
			result = null;
		} else {
			result = Date.valueOf(localDate);
		}
		return result;
	}

	@Override
	public LocalDate convertToEntityAttribute(final Date date) {
		final LocalDate result;
		if (date == null) {
			result = null;
		} else {
			result = date.toLocalDate();
		}
		return result;
	}

}
