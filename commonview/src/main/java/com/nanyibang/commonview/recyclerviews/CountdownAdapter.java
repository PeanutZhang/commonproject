package com.nanyibang.commonview.recyclerviews;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nanyibang.commonview.R;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

import static com.nanyibang.commonview.recyclerviews.CountdownAdapter.*;

/**
 * @Package: com.nanyibang.commonview.recyclerviews
 * @Description: recycler实现倒计时逻辑示例
 * @Author: zyh
 * @CreateDate: 2019/10/21
 * @company: 上海若美科技有限公司
 */
public class CountdownAdapter  extends RecyclerView.Adapter<MyViewHoler>{

    private List<Long> mDatas;
    private Set<MyViewHoler> mHolders;
    private ScheduledExecutorService mExecutorservice;
    public CountdownAdapter(List<Long> datas) {
        this.mDatas = datas==null ? new ArrayList<Long>():datas;
        mHolders = new HashSet<>();
        if(mDatas.isEmpty()){

            for (int i = 0; i < 30; i++) {
                mDatas.add(System.currentTimeMillis() + 3600 * 1000 * i);
            }
        }

        mExecutorservice = new ScheduledThreadPoolExecutor(1, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
//                thread.setName("countdown----");
                return thread;
            }
        });
        mExecutorservice.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                Log.e("zyh","---------------定时器------"+Thread.currentThread().getName());
//                for (MyViewHoler holder : mHolders) {
//                    upTime(holder,holder.getTime());
//                }
            }
        },0,1000, TimeUnit.MILLISECONDS);

    }

    @NonNull
    @Override
    public MyViewHoler onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
      View view =   LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_coundown,viewGroup,false);
        return new MyViewHoler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHoler holer, int position) {
        long remainTime = mDatas.get(position);
        holer.tvOrder.setText(String.format("第%1d项",position));
        holer.setTime(remainTime);
        mHolders.add(holer);
        upTime(holer,remainTime);
    }



    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    private void upTime(MyViewHoler holer,long remaintime) {
      long residue = remaintime - System.currentTimeMillis();//模拟时间
       residue /=1000;
        if(residue <=0){
          holer.tvTime.setText("活动已结束");
      }else {
          holer.tvTime.setText(String.format("倒计时剩余：%1$d秒",residue));
      }
    }//%[index]$标识符

    public static class MyViewHoler extends RecyclerView.ViewHolder {
        TextView tvOrder;
        TextView tvTime;
        long time;
        public MyViewHoler(@NonNull View itemView) {
            super(itemView);
            tvOrder = itemView.findViewById(R.id.order);
            tvTime = itemView.findViewById(R.id.tv_time);
        }

        public long getTime() {
            return time;
        }
        public void setTime(long time){
            this.time = time;
        }
    }
}
