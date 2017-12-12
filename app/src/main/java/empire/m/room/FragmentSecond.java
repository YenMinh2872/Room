package empire.m.room;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import empire.m.room.data.AppDatabase;
import empire.m.room.databinding.FragmentSecondBinding;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by YENMINH on 12/9/2017 5:15 PM.
 * Code and Life ( ^ .,,. ^ )
 * ---------------------------------------------
 */

public class FragmentSecond extends Fragment {

    FragmentSecondBinding binding;
    CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle
            savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_second, container, false);

        return binding.getRoot();
    }

    @Override
    public void onStart() {
        super.onStart();
        loadData();

    }


    @Override
    public void onStop() {
        super.onStop();
        compositeDisposable.clear();
    }

    private void loadData() {
        compositeDisposable.add(AppDatabase.getInstance(getActivity()).coinDao().getDTO()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        next -> binding.textView2.setText(String.valueOf(next.value)),
                        throwable -> Toast.makeText(getActivity(), throwable.getMessage(), Toast.LENGTH_SHORT).show()
                )
        );
    }
}
