package neuhoff.presidents;

import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class PresidentPagerAdapter extends PagerAdapter {

    private President[] presidents;
    private int[] pics;

    public PresidentPagerAdapter(President[] presidents, int[] pics) {
        this.presidents = presidents;
        this.pics = pics;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        LayoutInflater inflater = LayoutInflater.from(container.getContext());
        View view = inflater.inflate(R.layout.president_pager_item, null);

        ImageView image = (ImageView) view.findViewById(R.id.image);
        TextView name = (TextView) view.findViewById(R.id.name);
        TextView number = (TextView) view.findViewById(R.id.number);
        TextView office = (TextView) view.findViewById(R.id.office);
        TextView birthYear = (TextView) view.findViewById(R.id.birthYear);
        TextView party = (TextView) view.findViewById(R.id.party);

        President president = presidents[position];
        image.setImageResource(pics[position]);
        name.setText(president.getPresident());
        number.setText(String.valueOf(president.getNumber()));
        birthYear.append(String.valueOf(president.getBirthYear()));
        birthYear.append(" - ");
        if (president.getDeathYear() == null)
            birthYear.append("Still Alive");
        else
            birthYear.append(String.valueOf(president.getDeathYear()));
        office.append(president.getTookOffice());
        office.append(" - ");
        if (president.getLeftOffice() != null)
            office.append(president.getLeftOffice());
        else
            office.append("Still in Office");
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
