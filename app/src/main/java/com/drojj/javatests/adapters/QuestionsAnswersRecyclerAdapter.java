package com.drojj.javatests.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.drojj.javatests.model.question.Answer;
import com.drojj.javatests.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class QuestionsAnswersRecyclerAdapter extends RecyclerView.Adapter<QuestionsAnswersRecyclerAdapter.AnswerHolder> {

    private ArrayList<Answer> mAnswers;
    private int mChosenAnswerPosition;

    public QuestionsAnswersRecyclerAdapter(ArrayList<Answer> answers, int chosenAnswer) {
        this.mAnswers = answers;
        this.mChosenAnswerPosition = chosenAnswer;
    }

    @Override
    public AnswerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.answer_result_card_item, parent, false);
        return new AnswerHolder(v);
    }

    @Override
    public void onBindViewHolder(AnswerHolder holder, int position) {
        holder.answer_text.setText(mAnswers.get(position).getAnswerText());
        if (mChosenAnswerPosition == position) {
            holder.radioButton.setChecked(true);
        }
        if (mAnswers.get(position).isAnswerRight()) {
            holder.imageView.setVisibility(View.VISIBLE);
        } else {
            holder.imageView.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return mAnswers.size();
    }

    public class AnswerHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.result_answer_txt) TextView answer_text;

        @BindView(R.id.result_answer_radio) RadioButton radioButton;

        @BindView(R.id.result_image_right) ImageView imageView;

        public AnswerHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
