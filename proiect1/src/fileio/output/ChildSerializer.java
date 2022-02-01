package fileio.output;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import common.Constants;
import database.Child;

import java.io.IOException;

/**
 * Jackson serializer used for custom json output.
 */
public final class ChildSerializer extends StdSerializer<Child> {

    public ChildSerializer() {
        this(null);
    }

    public ChildSerializer(final Class<Child> t) {
        super(t);
    }

    @Override
    public void serialize(final Child child, final JsonGenerator jsonGenerator,
                          final SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();

        jsonGenerator.writeNumberField(Constants.ID, child.getId());
        jsonGenerator.writeStringField(Constants.LAST_NAME, child.getLastName());
        jsonGenerator.writeStringField(Constants.FIRST_NAME, child.getFirstName());
        jsonGenerator.writeStringField(Constants.CITY, child.getCity().getValue());
        jsonGenerator.writeNumberField(Constants.AGE, child.getAge());
        jsonGenerator.writeObjectField(Constants.GIFTS_PREFERENCES, child.getGiftsPreferences());
        jsonGenerator.writeNumberField(Constants.AVERAGE_SCORE, child.getAverageScore());
        jsonGenerator.writeObjectField(Constants.NICE_SCORE_HISTORY, child.getNiceScoreHistory());
        jsonGenerator.writeNumberField(Constants.ASSIGNED_BUDGET, child.getAssignedBudget());
        jsonGenerator.writeObjectField(Constants.RECEIVED_GIFTS, child.getReceivedGifts());

        jsonGenerator.writeEndObject();
    }
}
