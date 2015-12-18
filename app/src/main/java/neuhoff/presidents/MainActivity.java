package neuhoff.presidents;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity implements OnPresidentSelectedListener {

    PresidentListFragment listFragment;
    PresidentDetailFragment detailFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //support version so that older versions can use
        FragmentManager manager = getSupportFragmentManager();
        listFragment= (PresidentListFragment) manager.findFragmentById(R.id.listFragment);
        detailFragment = (PresidentDetailFragment) manager.findFragmentById(R.id.detailFragment);
    }


    @Override
    public void onSelect(President[] presidents, int position) {
        if (detailFragment != null) {
            detailFragment.showPresidentDetail(presidents, position);
        }

        else {
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra("PRESIDENTS", presidents);
            intent.putExtra("POSITION", position);
            this.startActivity(intent);
        }
    }
}
