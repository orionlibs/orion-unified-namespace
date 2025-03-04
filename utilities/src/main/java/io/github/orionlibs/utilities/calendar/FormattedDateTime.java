package io.github.orionlibs.utilities.calendar;

import io.github.orionlibs.core.object.CloningService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class FormattedDateTime
{
    private String longDate;
    private String dateSplitByHyphens;
    private String dateSplitBySlashes;
    private String dateSplitByHyphensYearFirst;
    private String dateSplitBySlashesYearFirst;
    private String time;
    private String timeWithISOFormat;
    private String formattedNumberOfYears;
    private String formattedNumberOfMonths;
    private String formattedNumberOfDays;
    private String formattedNumberOfHours;
    private String formattedNumberOfMinutes;
    private String formattedNumberOfSeconds;
    private String formattedDurationIn1Sentence;


    public static FormattedDateTime of()
    {
        return FormattedDateTime.builder().build();
    }


    @Override
    public FormattedDateTime clone()
    {
        return (FormattedDateTime)CloningService.clone(this);
    }


    public FormattedDateTime getCopy()
    {
        return this.clone();
    }
}