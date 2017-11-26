package com.smartcrops.ericfab17.smartcrop.view;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.smartcrops.ericfab17.smartcrop.R;
import com.smartcrops.ericfab17.smartcrop.databinding.RecyclerViewViewHolderBinding;
import com.smartcrops.ericfab17.smartcrop.model.AutomaticIrrigationTask;
import com.smartcrops.ericfab17.smartcrop.viewModel.AutomaticIrrigationTaskViewModel;

import java.util.Collections;
import java.util.List;

/**
 * Created by ericfab17 on 21/09/17.
 */

public class AutomaticIrrigationTaskAdapter extends RecyclerView.Adapter<AutomaticIrrigationTaskAdapter.AutomaticIrrigationTaskAdapterViewHolder> {
    
    private List<AutomaticIrrigationTask> automaticIrrigationTaskList;
    
    public AutomaticIrrigationTaskAdapter(){
        this.automaticIrrigationTaskList = Collections.emptyList();
    }

    @Override
    public AutomaticIrrigationTaskAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerViewViewHolderBinding recyclerViewViewHolderBinding
                = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.recycler_view_view_holder,parent,false);
        return new AutomaticIrrigationTaskAdapterViewHolder(recyclerViewViewHolderBinding);
    }

    @Override public void onBindViewHolder(AutomaticIrrigationTaskAdapterViewHolder holder, int position){
        holder.bindAutomaticIrrigationTask(automaticIrrigationTaskList.get(position));
    }
    @Override public int getItemCount() {
        return automaticIrrigationTaskList.size();
    }

    public void setAutomaticIrrigationTaskList(List<AutomaticIrrigationTask> automaticIrrigationTaskList){
        this.automaticIrrigationTaskList = automaticIrrigationTaskList;
        notifyDataSetChanged();
    }

    public static class AutomaticIrrigationTaskAdapterViewHolder extends RecyclerView.ViewHolder {
        RecyclerViewViewHolderBinding recyclerViewViewHolderBinding;

        public AutomaticIrrigationTaskAdapterViewHolder(RecyclerViewViewHolderBinding recyclerViewViewHolderBinding){
            super(recyclerViewViewHolderBinding.taskLinearLayout);
            this.recyclerViewViewHolderBinding = recyclerViewViewHolderBinding;
        }
        
        void bindAutomaticIrrigationTask(AutomaticIrrigationTask automaticIrrigationTask){
            if(recyclerViewViewHolderBinding.getAutoIrrigationTaskViewModel() == null){
                recyclerViewViewHolderBinding.setAutoIrrigationTaskViewModel( new AutomaticIrrigationTaskViewModel(automaticIrrigationTask));
            }
            else {
                recyclerViewViewHolderBinding.getAutoIrrigationTaskViewModel().setAutomaticIrrigationTask(automaticIrrigationTask);
            }
        }
    }
}
