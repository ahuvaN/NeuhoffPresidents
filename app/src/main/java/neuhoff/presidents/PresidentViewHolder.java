package neuhoff.presidents;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class PresidentViewHolder extends RecyclerView.ViewHolder{

    private TextView name;

    //itemView = president_list_item xml file
    public PresidentViewHolder(View itemView) {
        super(itemView);
        name = (TextView) itemView.findViewById(R.id.name);
    }

    public void bind(President president){
        name.setText(president.getPresident());
    }
}
