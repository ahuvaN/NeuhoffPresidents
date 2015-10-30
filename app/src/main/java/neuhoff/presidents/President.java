package neuhoff.presidents;


public class President {
    private int number, birthYear;
    private Integer deathYear;
    private String president, tookOffice, leftOffice, party;

    public String getLeftOffice() {
        return leftOffice;
    }

    public String getParty() {
        return party;
    }

    public String getTookOffice() {
        return tookOffice;
    }

    public Integer getDeathYear() {
        return deathYear;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public int getNumber() {
        return number;
    }

    public String getPresident() {
        return president;
    }
}
