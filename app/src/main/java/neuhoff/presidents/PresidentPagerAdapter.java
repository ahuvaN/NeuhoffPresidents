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

    public PresidentPagerAdapter(President[] presidents) {
        this.presidents = presidents;
        pics = new int[]{R.drawable.p1, R.drawable.p2, R.drawable.p3, R.drawable.p4, R.drawable.p5, R.drawable.p6, R.drawable.p7,
                R.drawable.p8, R.drawable.p9, R.drawable.p10, R.drawable.p11, R.drawable.p12, R.drawable.p13, R.drawable.p14,
                R.drawable.p15, R.drawable.p16, R.drawable.p17, R.drawable.p18, R.drawable.p19, R.drawable.p20, R.drawable.p21,
                R.drawable.p22, R.drawable.p23, R.drawable.p24, R.drawable.p25, R.drawable.p26, R.drawable.p27, R.drawable.p28,
                R.drawable.p29, R.drawable.p30, R.drawable.p31, R.drawable.p32, R.drawable.p33, R.drawable.p34, R.drawable.p35,
                R.drawable.p36, R.drawable.p37, R.drawable.p38, R.drawable.p39, R.drawable.p40, R.drawable.p41, R.drawable.p42,
                R.drawable.p43, R.drawable.p44};
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
