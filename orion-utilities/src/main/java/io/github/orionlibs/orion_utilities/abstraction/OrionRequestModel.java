package io.github.orionlibs.orion_utilities.abstraction;

import io.github.orionlibs.orion_utilities.object.CloningService;

public class OrionRequestModel implements OrionModel
{
    public OrionRequestModel()
    {
    }


    @Override
    public OrionRequestModel clone()
    {
        return (OrionRequestModel)CloningService.clone(this);
    }


    @Override
    public OrionRequestModel getCopy()
    {
        return this.clone();
    }
}