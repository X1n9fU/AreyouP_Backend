package com.example.areyoup.job.domain;

import com.example.areyoup.job.dto.JobRequestDto;
import com.example.areyoup.job.dto.JobResponseDto;
import com.example.areyoup.member.Member;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@DiscriminatorValue("S")
@NoArgsConstructor
@Getter
@SuperBuilder
public class SeperatedJob extends Job{

    //CustomizeJob에서 조정된 일정
    private LocalDate day; //일정이 배치된 날짜
    private Integer completion; //완료도

    public void toUpdateCompletion(Integer completion, boolean isComplete){
        this.completion = completion;
        this.isComplete = isComplete;
    }

    public static JobResponseDto.SeperatedJobResponseDto toSeperatedJobDto(SeperatedJob seperatedJob) {
        return JobResponseDto.SeperatedJobResponseDto.toDto(seperatedJob);
    }

    public void toUpdateAll(JobRequestDto.UpdateJobRequestDto updateJob) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        LocalDate day = LocalDate.parse(updateJob.getDay(), dtf);

        this.name = updateJob.getName();
        this.label = updateJob.getLabel();
        this.startTime = updateJob.getStartTime();
        this.endTime = updateJob.getEndTime();
        this.estimatedTime = updateJob.getEstimatedTime();
        this.isComplete = updateJob.isComplete();
        this.day = day;
        this.completion = updateJob.getCompletion();
        this.isFixed = updateJob.isFixed();
    }
}