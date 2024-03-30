package com.example.areyoup.job.repository;

import com.example.areyoup.job.domain.CustomizeJob;
import com.example.areyoup.job.domain.SeperatedJob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface CustomizeJobRepository extends JpaRepository<CustomizeJob, Long> {
    //start - end 사이의 일정 모두 반환
    List<CustomizeJob> findByStartDateBetweenAndIsFixedIsTrue(LocalDate start, LocalDate end);
    List<CustomizeJob> findByStartTimeIsNull();
    CustomizeJob findByName(String name);

    List<CustomizeJob> findAllByMemberId(Long memberId);


}
