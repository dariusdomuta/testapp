package darius.com.tasks.Adapters;

import darius.com.tasks.Models.Task;
import darius.com.tasks.R;
import io.realm.OrderedRealmCollection;
import io.realm.RealmRecyclerViewAdapter;
import io.realm.RealmResults;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

/**
 * Created by dariu on 12/12/2017.
 */

public class RecyclerViewAdapter extends RealmRecyclerViewAdapter<Task, RecyclerViewAdapter.TaskViewHolder> {

    public RecyclerViewAdapter(@Nullable OrderedRealmCollection<Task> data, boolean autoUpdate) {
        super(data, autoUpdate);
        setHasStableIds(true);
    }

    class TaskViewHolder extends RecyclerView.ViewHolder {
        TextView descriptionTextView;
        CheckBox doneCheckBox;
        public Task data;

        public TaskViewHolder(View view){
            super(view);
            descriptionTextView = (TextView) view.findViewById(R.id.single_task_description);
            doneCheckBox = (CheckBox) view.findViewById(R.id.single_task_check);

        }
    }



    @Override
    public TaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_task, parent, false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TaskViewHolder holder, int position) {
        final Task task = getItem(position);
        holder.data = task;

        holder.descriptionTextView.setText(task.getDescrition());
        holder.doneCheckBox.setChecked(task.isDone());
    }
}
