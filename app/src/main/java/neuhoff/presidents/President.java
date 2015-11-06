package neuhoff.presidents;


import java.io.Serializable;

public class President implements Serializable{
    private int number, birthYear;
    private Integer deathYear;
    private String president, tookOffice, leftOffice, party;

    public String getPresident() {
        return president;
    }

    public int getNumber() {
        return number;
    }

    public String getTookOffice() {
        return tookOffice;
    }

    public String getLeftOffice() {
        return leftOffice;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public Integer getDeathYear() {
        return deathYear;
    }

    public String getParty() {
        return party;
    }

}
