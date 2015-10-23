package neuhoff.presidents;

/**
 * Created by Ahuva on 10/22/2015.
 */
public class President {
    private int number, birth_year, death_year;
    private String president, took_office, left_office, party;

    public String getLeft_office() {
        return left_office;
    }

    public String getParty() {

        return party;
    }

    public String getTook_office() {

        return took_office;
    }

    public int getDeath_year() {

        return death_year;
    }

    public int getBirth_year() {

        return birth_year;
    }

    public int getNumber() {
        return number;
    }

    public String getPresident() {
        return president;
    }
}
