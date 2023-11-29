//[참고] https://dpdpwl.tistory.com/3
//[참고] https://github.com/TutorDot/TutorDot_iOS => 진짜 정리 잘되어있음(IOS..)
package com.example.myapplication.view.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.myapplication.R;
import com.example.myapplication.view.object.Decorator.DayViewDecorator;
import com.example.myapplication.view.object.Decorator.DayViewDecorator2;
import com.example.myapplication.view.object.Decorator.DayViewDecorator3;
import com.example.myapplication.view.object.Decorator.DayViewDecorator4;
import com.example.myapplication.view.object.Decorator.EventDecorator;
import com.example.myapplication.view.object.Decorator.SaturdayDecorator;
import com.example.myapplication.view.object.Decorator.SundayDecorator;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.CalendarMode;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;


import java.util.Calendar;
import java.util.Collections;
import java.util.Date;

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

        // 원의 크기 조절을 위한 OnDateSelectedListener 설정
        calendarView.setOnDateChangedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(
                    MaterialCalendarView widget,
                    CalendarDay date,
                    boolean selected
            ) {

                // 선택된 날짜 주변의 원의 크기 조절
                if (selected) {
                    adjustSelectionCircle(date);
                }
            }
        });

        calendarView.setSelectedDate(new Date(System.currentTimeMillis())); // 오늘날짜 선택
        calendarView.setShowOtherDates(MaterialCalendarView.SHOW_OUT_OF_RANGE); // 해당월의 최소값 이전의 날들, 최대값 이후의 날을 끝까지 보여준다
        //calendarView.setDynamicHeightEnabled(true); // 4주만 있는게 아니라 5, 6주가 되는 월도 있기에 높이를 dynamic하게 보여줄 것이다라는 뜻
        //calendarView.setPadding(0, -20, 0, 30);

        //calendarView.addDecorators(new CustomDayViewDecorator(calendarView));

        calendarView.addDecorator(new EventDecorator(Color.RED, Collections.singleton(CalendarDay.today()))); // 오늘날짜에 색상 표시

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

    // 선택된 날짜 주변의 원 크기 조절 메서드
    private void adjustSelectionCircle(CalendarDay selectedDate) {
//        // 선택된 날짜에 해당하는 CalendarDayView 가져오기
//        DayViewFacade dayViewFacade = calendarView.getDateTextAppearance(selectedDate);
//        if (dayViewFacade != null) {
//            // 선택된 날짜에 원의 색상을 적용
//            dayViewFacade.addSpan(new DotSpan(6, getResources().getColor(R.color.teal_200)));
//
//            // 선택된 날짜 외의 날짜의 원을 투명하게 설정
//            for (CalendarDay otherDay : calendarView.getSelectedDates()) {
//                if (!otherDay.equals(selectedDate)) {
//                    DayViewFacade otherDayViewFacade = calendarView.getDateTextAppearance(otherDay);
//                    if (otherDayViewFacade != null) {
//                        otherDayViewFacade.addSpan(new DotSpan(0, Color.TRANSPARENT));
//                    }
//                }
//            }
//        }

//        // 선택된 날짜에 해당하는 날짜를 가져오기
//        CalendarDay today = CalendarDay.today();
//
//        // 선택된 날짜에 원의 색상을 적용
//        if (selectedDate.equals(today)) {
//            //calendarView.addDecorators(new CustomDayViewDecorator(selectedDate, Color.YELLOW));
//            calendarView.addDecorators(new DayViewDecorator(selectedDate, Color.YELLOW));
//        }
//
//        // 나머지 날짜의 원을 투명하게 설정
//        for (CalendarDay otherDay : calendarView.getSelectedDates()) {
//            if (!otherDay.equals(selectedDate)) {
//                calendarView.addDecorators(new DayViewDecorator(selectedDate, Color.TRANSPARENT));
//            }
//        }

        //calendarView.addDecorators(new DayViewDecorator(selectedDate, Color.rgb(30, 35, 62)));
        //calendarView.addDecorators(new DayViewDecorator(selectedDate, Color.rgb(104, 117, 221)));
        calendarView.addDecorators(new DayViewDecorator(this.getContext(), selectedDate, Color.rgb(235, 234, 234)));
    }
}


// [여기서 한번 적용해보기] https://onlyfor-me-blog.tistory.com/437