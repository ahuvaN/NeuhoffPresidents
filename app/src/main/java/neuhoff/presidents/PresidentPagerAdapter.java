package neuhoff.presidents;

import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class PresidentPagerAdapter extends PagerAdapter {

    private President[] presidents;

    public PresidentPagerAdapter(President[] presidents) {
        this.presidents = presidents;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        LayoutInflater inflater = LayoutInflater.from(container.getContext());
        View view = inflater.inflate(R.layout.president_pager_item, null);
        TextView name = (TextView) view.findViewById(R.id.name);
        TextView number = (TextView) view.findViewById(R.id.number);
        TextView tookOffice = (TextView) view.findViewById(R.id.tookOffice);
        TextView leftOffice = (TextView) view.findViewById(R.id.leftOffice);
        TextView birthYear = (TextView) view.findViewById(R.id.birthYear);
        TextView deathYear = (TextView) view.findViewById(R.id.deathYear);
        TextView party = (TextView) view.findViewById(R.id.party);

        President president = presidents[position];
        name.append("\nName= \t");
        name.append(president.getPresident());
        number.append("\nNumber= \t");
        number.append(String.valueOf(president.getNumber()));
        birthYear.append("\nBorn= \t");
        birthYear.append(String.valueOf(president.getBirthYear()));
        deathYear.append("\nDied= \t");
        if (president.getDeathYear() == null)
            deathYear.append("Still Alive");
        else
            deathYear.append(String.valueOf(president.getDeathYear()));
        tookOffice.append("\nTook Office= \t");
        tookOffice.append(president.getTookOffice());
        leftOffice.append("\nLeft Office= \t");
        if (president.getLeftOffice() != null)
            leftOffice.append(president.getLeftOffice());
        else
            leftOffice.append("Still in Office");
        party.append("\nParty= \t");
        party.append(president.getParty());

        container.addView(view);
        return view;
    }

    @Override
    public int getCount() {
        return presidents.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
