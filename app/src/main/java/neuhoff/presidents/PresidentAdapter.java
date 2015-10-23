package neuhoff.presidents;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

//handles the creation of viewable ist and the one that is going to be created as soon as list is scrolled
public class PresidentAdapter extends RecyclerView.Adapter<PresidentViewHolder> {

    private President[] presidents;

    public PresidentAdapter(President[] presidents){
        this.presidents = presidents;
    }
    @Override
    public PresidentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.president_list_item, parent, false);
        return new PresidentViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PresidentViewHolder holder, int position) {
        holder.bind(presidents[position]);
    }

    @Override
    public int getItemCount() {
        return presidents.length;
    }
}
