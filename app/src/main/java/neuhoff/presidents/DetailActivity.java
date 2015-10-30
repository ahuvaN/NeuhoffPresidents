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

        viewPager = (ViewPager) findViewById(R.id.viewPager);

        PresidentPagerAdapter adapter = new PresidentPagerAdapter(MainActivity.presidents);
        viewPager.setAdapter(adapter);
    }
}
