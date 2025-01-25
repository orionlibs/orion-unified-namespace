package io.github.orionlibs.utilities.document.json.tasks;

import com.google.gson.Gson;
import io.github.orionlibs.utilities.abstraction.Orion;
import io.github.orionlibs.utilities.document.json.JSONObject;
import io.github.orionlibs.utilities.exception.Assert;
import io.github.orionlibs.utilities.exception.InvalidArgumentException;

public class ConvertJSONObjectToStringTask extends Orion
{
    public static String run(JSONObject jsonObject)
    {
        Assert.notNull(jsonObject, "The given jsonObject is null.");

        if(jsonObject.getJSONStringData() != null)
        {
            return jsonObject.getJSONStringData();
        }
        else if(jsonObject.getJSONMapData() != null)
        {
            return new Gson().toJson(jsonObject.getJSONMapData());
        }
        else
        {
            throw new InvalidArgumentException("The given jsonObject does not have mapData or stringData in it.");
        }

    }
}