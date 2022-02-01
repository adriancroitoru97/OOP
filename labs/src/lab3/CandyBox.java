package lab3;

import java.util.Objects;

public class CandyBox {
    private String flavor;
    private String origin;

    public CandyBox() {
        this("Standard", "Standard");
    }

    public CandyBox(String flavor, String origin) {
        this.flavor = flavor;
        this.origin = origin;
    }

    float getVolume() {
        return 0;
    }

    @Override
    public String toString() {
        return "CandyBox{" +
                "flavor='" + flavor + '\'' +
                ", origin='" + origin + '\'' +
                '}';
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    /* Criteriul de echivalenta ales este volumul cutiei, caracteristica
    * aceasta fiind specifica tuturor claselor copil ale clasei parinte
    * CandyBox */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CandyBox candyBox = (CandyBox) o;
        return Objects.equals(getVolume(), candyBox.getVolume());
    }

    /* Task 6: ca sa nu folosesc instaneof, creez o metoda de print aici */
    void printCandy() {
        System.out.println(this);
    }
}
