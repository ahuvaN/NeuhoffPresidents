package neuhoff.presidents;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.InputStream;
import java.io.InputStreamReader;

public class PresidentListFragment extends Fragment{
    private RecyclerView recyclerView;
    private President[] presidents;
    private int[] pics;

    //fragment is alot like an activity
    @Nullable
    @Override
    //returns a view
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_president_list, container, false);
    }

    @Override
    public void onOptionsMenuClosed(Menu menu) {
        super.onOptionsMenuClosed(menu);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        recyclerView = (RecyclerView) view.findViewById(R.id.list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getContext());
        //main extends AppCompat which extends Context.....
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();

        InputStream in = getResources().openRawResource(R.raw.presidents);

        presidents = gson.fromJson(new InputStreamReader(in), President[].class);

        OnPresidentSelectedListener listener = (OnPresidentSelectedListener) getActivity();

        PresidentRecyclerViewAdapter adapter =
                new PresidentRecyclerViewAdapter(presidents, listener);
        recyclerView.setAdapter(adapter);


    }
}
