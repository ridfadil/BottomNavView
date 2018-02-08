package id.ac.uinsgd.anif.journal;

import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import id.ac.uinsgd.anif.journal.Model.Journal;

public class ListJournalActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    String[] judul = {"Aplikasi Pengenalan Bahasa Arab dan Inggris untuk Anak-Anak Berbasis Android", "tes", "tes"};
    int [] coverId = {R.drawable.cover, R.drawable.cover, R.drawable.cover};
    String[] lastIssue = {"Lorem Ipsum", "Ipsum Lorem", "Lorme Ipsum"};
    String[] issn = {"issn1", "issn2", "issn3"};

    android.support.v7.widget.Toolbar toolbar;
    RecyclerView recyclerView;
    JournalAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Journal> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_journal);
        toolbar = findViewById(R.id.tb_toolbar);
        setSupportActionBar(toolbar);
        recyclerView = findViewById(R.id.rv_listJournal);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);


        for (int count= 0; count<3; count++ ){
            arrayList.add(new Journal(judul[count], coverId[count], lastIssue[count], issn[count]  ));
        }

        adapter = new JournalAdapter(arrayList);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_items, menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
        searchView.setOnQueryTextListener(this);
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        newText = newText.toLowerCase();
        ArrayList<Journal> newList = new ArrayList<>();
        for(Journal journal :arrayList){
            String judul = journal.getJudul().toLowerCase();
            if(judul.contains(newText))
                newList.add(journal);
        }

        adapter.setFilter(newList);
        return true;
    }
}
