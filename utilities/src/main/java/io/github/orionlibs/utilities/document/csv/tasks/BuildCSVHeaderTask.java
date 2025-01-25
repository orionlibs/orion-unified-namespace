package io.github.orionlibs.utilities.document.csv.tasks;

import io.github.orionlibs.utilities.document.csv.CSVWriterService;
import java.util.List;

public class BuildCSVHeaderTask
{
    public static String run(List<String> headerColumnNames)
    {
        String header = "";

        if(headerColumnNames != null && !headerColumnNames.isEmpty())
        {

            for(int i = 0; i < headerColumnNames.size(); i++)
            {
                header += "\"" + CSVWriterService.sanitiseValue(headerColumnNames.get(i)) + "\"";

                if(i < headerColumnNames.size() - 1)
                {
                    header += ",";
                }
                else
                {
                    header += "\n";
                }

            }

        }

        return header;
    }
}