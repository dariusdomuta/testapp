package darius.com.tasks.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.UUID;

import darius.com.tasks.Adapters.RecyclerViewAdapter;
import darius.com.tasks.Models.Task;
import darius.com.tasks.R;
import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    private Realm realm;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        realm.init(this);
        realm = Realm.getDefaultInstance();

        realm.beginTransaction();
        Task task = realm.createObject(Task.class, UUID.randomUUID().toString());
        task.setDescrition("The first task");
        task.setDone(true);
        realm.commitTransaction();

        realm.beginTransaction();
        Task task1 = realm.createObject(Task.class, UUID.randomUUID().toString());
        task1.setDescrition("The first task");
        task1.setDone(true);
        realm.commitTransaction();

        RealmResults<Task> tasks = realm
                .where(Task.class)
                .findAll();

        recyclerView = (RecyclerView) findViewById(R.id.list_of_tasks);

        adapter = new RecyclerViewAdapter(tasks, true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }
}
