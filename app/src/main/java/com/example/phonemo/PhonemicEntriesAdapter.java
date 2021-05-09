package com.example.phonemo;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public abstract class PhonemicEntriesAdapter extends RecyclerView.Adapter<PhonemicEntriesAdapter.ViewHolder> {
    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nameTextView;
        public Button contextButton;

        public ViewHolder(View itemView) {
            super(itemView);
            nameTextView = (TextView) itemView.findViewById(R.id.phonemic_word);
            contextButton = (Button) itemView.findViewById(R.id.context_button);
        }
    }

    private List<PhonemicEntry> bestPhonemicEntries;

    public PhonemicEntriesAdapter(List<PhonemicEntry> phonemicEntries) {
        bestPhonemicEntries = phonemicEntries;
    }

//    public PhonemicEntriesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        Context context = parent.getContext();
//        LayoutInflater inflater = LayoutInflater.from(context);
//
//    }
}
