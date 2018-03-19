package com.treever_template_tester.ui.main_screen;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.treever_template_tester.R;
import com.treever_template_tester.model.ModelTemplate;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Provider;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Abgaryan on 3/18/18.
 */

public class TemplateAdapter extends  RecyclerView.Adapter<TemplateAdapter.TemplateViewHolder> implements Provider<TemplateAdapter> {

    List<ModelTemplate> mModelTemplates;

    @Inject
    public TemplateAdapter() {
        mModelTemplates = new ArrayList<>();
    }

    public void setModelTemplates(List<ModelTemplate> mModelTemplates) {
        this.mModelTemplates = mModelTemplates;
    }

    @Override
    public TemplateViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_template, parent, false);
        return new TemplateViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TemplateViewHolder holder, int position) {
        ModelTemplate modelTemplate = mModelTemplates.get(position);
        String str ="#"+modelTemplate.getTemplate_cloud_id() +"     "+ modelTemplate.getFile_name();
        holder.titleTextView.setText(str);

    }

    @Override
    public int getItemCount() {
        return mModelTemplates.size();
    }

    @Override
    public TemplateAdapter get() {
        return this;
    }

    class TemplateViewHolder extends RecyclerView.ViewHolder {


    @BindView(R.id.title_template)
    TextView titleTextView;

    public TemplateViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

}

}
