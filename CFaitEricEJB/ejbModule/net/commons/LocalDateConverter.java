package net.commons;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Le CDT ROBIN a créé un converter généric ...a voir (sur internet)
 * 
 * @author eric.gabriac
 *
 */
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
