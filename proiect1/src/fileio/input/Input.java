package fileio.input;

import java.util.List;

public final class Input {

    private final Integer numberOfYears;
    private final Integer santaBudget;
    private final InitialDataInputData initialData;
    private final List<AnnualChangeInputData> annualChanges;

    public Input() {
        this.numberOfYears = null;
        this.santaBudget = null;
        this.initialData = null;
        this.annualChanges = null;
    }

    public Input(final Integer numberOfYears, final Integer santaBudget,
                 final InitialDataInputData initialData,
                 final List<AnnualChangeInputData> annualChanges) {
        this.numberOfYears = numberOfYears;
        this.santaBudget = santaBudget;
        this.initialData = initialData;
        this.annualChanges = annualChanges;
    }

    public Integer getNumberOfYears() {
        return numberOfYears;
    }

    public Integer getSantaBudget() {
        return santaBudget;
    }

    public InitialDataInputData getInitialData() {
        return initialData;
    }

    public List<AnnualChangeInputData> getAnnualChanges() {
        return annualChanges;
    }
}
