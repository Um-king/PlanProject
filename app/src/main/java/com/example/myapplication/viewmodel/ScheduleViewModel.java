package com.example.myapplication.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.disposables.CompositeDisposable;

import com.example.myapplication.model.service.ScheduleService;

public class ScheduleViewModel extends ViewModel {
    // 데이터를 가져오는 것에 성공했는지를 알려주는 데이터(앱버전)
    public MutableLiveData<Boolean> loadError = new MutableLiveData<>();//false면 성공, true면 에러
    // 로딩 중인지를 나타내는 데이터
    public MutableLiveData<Boolean> loading = new MutableLiveData<>();
    // 서버 객체 호출 : api를 통해 서버와 연결된다.
    public ScheduleService service = ScheduleService.getInstance();//todo
    // 사용후 폐기하기 위해, 사용이 끝나면 한꺼번에 폐기한다.
    private CompositeDisposable disposable = new CompositeDisposable();

    // 데이터 호출
    public void GetData(){


    }
}
