package id.ac.uinsgd.anif.journal;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import id.ac.uinsgd.anif.journal.Model.Journal;

/**
 * Created by adam on 2/1/18.
 */

public class JournalAdapter extends RecyclerView.Adapter<JournalAdapter.MyViewHolder> {

    public ArrayList<Journal> arrayList = new ArrayList<>() ;
    JournalAdapter(ArrayList<Journal> arrayList){
        this.arrayList = arrayList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout,parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.coverId.setImageResource(arrayList.get(position).getCoverId());
        holder.judul.setText(arrayList.get(position).getJudul());
        holder.lastIssue.setText(arrayList.get(position).getLastIssue());
        holder.issn.setText(arrayList.get(position).getIssn());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView coverId;
        TextView judul;
        TextView lastIssue;
        TextView issn;

        public MyViewHolder(View itemView) {
            super(itemView);
            coverId = itemView.findViewById(R.id.cover);
            judul = itemView.findViewById(R.id.tv_judulJurnal);
            lastIssue = itemView.findViewById(R.id.tv_lastIssue);
            issn = itemView.findViewById(R.id.tv_issn);
        }
    }

    public void setFilter(ArrayList<Journal> newList){
        arrayList = new ArrayList<>();
        arrayList.addAll(newList);
        notifyDataSetChanged();
    }
}
