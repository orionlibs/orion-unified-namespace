package io.github.orionlibs.orion_utilities.document.json.tasks;

import io.github.orionlibs.orion_utilities.abstraction.Orion;
import io.github.orionlibs.orion_utilities.document.json.JSONObject;
import io.github.orionlibs.orion_utilities.document.json.JSONService;
import io.github.orionlibs.orion_utilities.exception.Assert;
import io.github.orionlibs.orion_utilities.exception.InvalidArgumentException;
import java.util.Map;

public class ConvertJSONObjectToMapTask extends Orion
{
    public static Map<?, ?> run(JSONObject jsonObject)
    {
        Assert.notNull(jsonObject, "The given jsonObject is null.");

        if(jsonObject.getJSONMapData() != null)
        {
            return jsonObject.getJSONMapData();
        }
        else if(jsonObject.getJSONStringData() != null)
        {
            return JSONService.convertJSONToMap(jsonObject.getJSONStringData());
        }
        else
        {
            throw new InvalidArgumentException("The given jsonObject does not have mapData or stringData in it.");
        }

    }
}