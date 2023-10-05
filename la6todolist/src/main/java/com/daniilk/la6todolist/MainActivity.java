package com.daniilk.la6todolist;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewNotes;
    private NotesAdapter notesAdapter;
    private FloatingActionButton buttonAddNote;
//    private NoteDatabase notesDatabase;
//    private Handler handler = new Handler(Looper.getMainLooper());

    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        viewModel = new MainViewModel(getApplication());
        viewModel = new ViewModelProvider(this).get(MainViewModel.class); // viewModel переживает переворот экрана
//        viewModel.getCount().observe(this, new Observer<Integer>() {
//            @Override
//            public void onChanged(Integer count) {
//                Toast.makeText(MainActivity.this, String.valueOf(count), Toast.LENGTH_SHORT).show();
//            }
//        });

//        notesDatabase = NoteDatabase.getInstance(getApplication());

        initViews();

        notesAdapter = new NotesAdapter();
//        notesAdapter.setOnNoteClickListener(new NotesAdapter.OnNoteClickListener() {
//            @Override
//            public void onNoteClick(Note note) {
////                database.removeById(note.getId());
////                showNotes();
//
//                viewModel.showCount();
//            }
//        });
        recyclerViewNotes.setAdapter(notesAdapter);
//        recyclerViewNotes.setLayoutManager(new LinearLayoutManager(this));

        viewModel.getNotes().observe(this, new Observer<List<Note>>() {
            @Override
            public void onChanged(List<Note> notes) {
                notesAdapter.setNotes(notes);
            }
        });

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(
                new ItemTouchHelper.SimpleCallback(
                        0,
                        ItemTouchHelper.RIGHT | ItemTouchHelper.LEFT
                ) {
                    @Override
                    public boolean onMove(
                            @NonNull RecyclerView recyclerView,
                            @NonNull RecyclerView.ViewHolder viewHolder,
                            @NonNull RecyclerView.ViewHolder target
                    ) {
                        return false;
                    }

                    @Override
                    public void onSwiped(
                            @NonNull RecyclerView.ViewHolder viewHolder,
                            int direction
                    ) {
                        int position = viewHolder.getAdapterPosition();

                        Note note = notesAdapter.getNotes().get(position);
                        viewModel.remove(note);
//                        Thread thread = new Thread(new Runnable() {
//                            @Override
//                            public void run() {
//                                notesDatabase.notesDao().remove(note.getId());
//
////                                handler.post(new Runnable() {
////                                    @Override
////                                    public void run() {
////                                        showNotes();
////                                    }
////                                });
//                            }
//                        });
//                        thread.start();

                    }
                });
        itemTouchHelper.attachToRecyclerView(recyclerViewNotes);

//        showNotes();
        buttonAddNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = AddNoteActivity.newIntent(MainActivity.this);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
//        showNotes();
//        viewModel.refreshList();
    }

    private void initViews() {
        recyclerViewNotes = findViewById(R.id.recyclerViewNotes);
        buttonAddNote = findViewById(R.id.buttonAddNote);
    }

    private void showNotes() {
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//                List<Note> notes = notesDatabase.notesDao().getNotes();
//
//                handler.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        notesAdapter.setNotes(notes);
//                    }
//                });
//            }
//        });
//        thread.start();
    }
}