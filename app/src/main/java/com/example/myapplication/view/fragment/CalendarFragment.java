//[참고] https://dpdpwl.tistory.com/3
//[참고] https://github.com/TutorDot/TutorDot_iOS => 진짜 정리 잘되어있음(IOS..)
package com.example.myapplication.view.fragment;

import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;
import com.example.myapplication.view.object.Decorator.EventDecorator;
import com.example.myapplication.view.object.Decorator.SaturdayDecorator;
import com.example.myapplication.view.object.Decorator.SundayDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.CalendarMode;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;
import com.prolificinteractive.materialcalendarview.OnRangeSelectedListener;


import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class CalendarFragment extends Fragment {

    MaterialCalendarView calendarView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_calendar2, container, false);
        calendarView = v.findViewById(R.id.calendarView);

        init();

        // Inflate the layout for this fragment
        return v;
    }

    private void init(){

        calendarView.setOnRangeSelectedListener(new OnRangeSelectedListener() {
            @Override
            public void onRangeSelected(@NonNull MaterialCalendarView widget, @NonNull List<CalendarDay> dates) {
                calendarView.addDecorator(new EventDecorator(Color.RED, Collections.singleton(CalendarDay.today()), getActivity())); // 오늘날짜에 색상 표시
            }
        });

        calendarView.setSelectedDate(new Date(System.currentTimeMillis())); // 오늘날짜 선택
        calendarView.setShowOtherDates(MaterialCalendarView.SHOW_OUT_OF_RANGE); // 해당월의 최소값 이전의 날들, 최대값 이후의 날을 끝까지 보여준다
        //calendarView.setDynamicHeightEnabled(true); // 4주만 있는게 아니라 5, 6주가 되는 월도 있기에 높이를 dynamic하게 보여줄 것이다라는 뜻
        //calendarView.setPadding(0, -20, 0, 30);

//        calendarView.addDecorator(new ScheduleDecorator(Color.RED, Collections.singleton(CalendarDay.today()))); // 오늘날짜에 색상 표시
        //calendarView.addDecorator(new EventDecorator(Color.RED, Collections.singleton(CalendarDay.today()), getActivity())); // 오늘날짜에 색상 표시

        calendarView.state().edit()
                .setFirstDayOfWeek(Calendar.SUNDAY)
                .setMinimumDate(CalendarDay.from(1900,1,1))
                .setMaximumDate(CalendarDay.from(5000, 12, 31))
                .setCalendarDisplayMode(CalendarMode.MONTHS)
                .commit();

        // 오늘날짜 표시
//        calendarView.addDecorators(
//                new SundayDecorator(),
//                new SaturdayDecorator(),
//                new TodayDecorator());
        
        calendarView.addDecorators(
                new SundayDecorator(),
                new SaturdayDecorator());

    }
}


// [여기서 한번 적용해보기] https://onlyfor-me-blog.tistory.com/437