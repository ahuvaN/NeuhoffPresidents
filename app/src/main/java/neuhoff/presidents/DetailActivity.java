package neuhoff.presidents;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatAutoCompleteTextView;

public class DetailActivity extends AppCompatActivity {

    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detail);

        int position = getIntent().getIntExtra("POSITION", 0);

        viewPager = (ViewPager) findViewById(R.id.viewPager);

        President presidents[] = (President[]) getIntent().getSerializableExtra("PRESIDENTS");
        int pics[] = getIntent().getIntArrayExtra("PICS");
        PresidentPagerAdapter adapter = new PresidentPagerAdapter(presidents, pics);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(position);
    }
}
