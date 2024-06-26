package com.example.areyoup.job.domain;

import com.example.areyoup.global.function.DateTimeHandler;
import com.example.areyoup.job.dto.JobRequestDto;
import com.example.areyoup.job.dto.JobResponseDto;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Entity
@DiscriminatorValue("S")
@NoArgsConstructor
@Getter
@SuperBuilder
public class SeperatedJob extends Job{

    //CustomizeJob에서 조정된 일정
    private LocalDate day; //일정이 배치된 날짜

    public void toUpdateCompletionAndComplete(Integer completion, boolean isComplete){
        this.completion = completion;
        this.isComplete = isComplete;
    }

    public static JobResponseDto.SeperatedJobResponseDto toSeperatedJobDto(SeperatedJob seperatedJob) {
        return JobResponseDto.SeperatedJobResponseDto.toDto(seperatedJob);
    }

    public void toUpdateAll(JobRequestDto.UpdateJobRequestDto updateJob) {
        this.name = updateJob.getName();
        this.label = updateJob.getLabel();
        this.startTime = updateJob.getStartTime();
        this.endTime = updateJob.getEndTime();
        this.estimatedTime = updateJob.getEstimatedTime();
        this.isComplete = updateJob.isComplete();
        this.day = DateTimeHandler.strToDate(updateJob.getDay());
        this.completion = updateJob.getCompletion();
        this.isFixed = updateJob.isFixed();
    }

    public void toUpdateCompletion(Integer completion) {
        this.completion = completion;
    }
}
