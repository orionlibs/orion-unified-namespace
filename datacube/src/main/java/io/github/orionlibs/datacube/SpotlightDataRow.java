package io.github.orionlibs.datacube;

import lombok.ToString;

//Has to match the exact order of columns in the CSV file
//@JsonPropertyOrder({"city","lat","lng","country","iso2", "adminName","capital","population"})
@ToString
public class SpotlightDataRow
{
    public String empty;
    public String financialYear;
    public String opExCategory;
    public String emsLevel1;
    public String emsLevel2;
    public String emsLevel3;
    public String emsLevel4;
    public String company;
    public Double movement;
    public Double backDatedJournals;
    public Double backDatedJournalLinesDebitValue;
}
