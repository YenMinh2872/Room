package empire.m.room;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import empire.m.room.data.AppDatabase;
import empire.m.room.data.ItemValue;
import empire.m.room.databinding.FragmentMainBinding;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.schedulers.ExecutorScheduler;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by YENMINH on 12/9/2017 5:15 PM.
 * Code and Life ( ^ .,,. ^ )
 * ---------------------------------------------
 */

public class FragmentMain extends Fragment {

    FragmentMainBinding binding;
    private ItemValue itemValue;
    CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle
            savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false);
        setupView();
        return binding.getRoot();
    }

    @Override
    public void onStart() {
        super.onStart();
        insertData();
    }

    @Override
    public void onStop() {
        super.onStop();
        compositeDisposable.clear();
    }

    private void setupView() {
        binding.button.setOnClickListener(view -> {
            insertData();
            binding.textView.setText(String.valueOf(itemValue.value));
        });
    }

    private void insertData() {
        if (itemValue != null) {
            itemValue.value = itemValue.value + 1;
            Executor executor = Executors.newSingleThreadExecutor();
            executor.execute(() -> AppDatabase.getInstance(getActivity()).coinDao().updateDTO(itemValue));
        } else {
            itemValue = new ItemValue();
            itemValue.value = 0;
            compositeDisposable.add(
                    Observable.fromCallable(() -> AppDatabase.getInstance(getActivity()).coinDao().insertCoinDTO
                            (itemValue))
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe());
        }


//        compositeDisposable.add(AppDatabase.getInstance(getActivity()).coinDao().insertCoinDTO(itemValue)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe()
//        );
    }


    private void loadData() {
        compositeDisposable.add(AppDatabase.getInstance(getActivity()).coinDao().getDTO()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        next -> itemValue = next,
                        throwable -> Toast.makeText(getActivity(), throwable.getMessage(), Toast.LENGTH_SHORT).show()
                )
        );
    }
}
