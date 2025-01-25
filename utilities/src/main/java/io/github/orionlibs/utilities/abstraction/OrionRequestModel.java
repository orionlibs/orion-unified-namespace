package io.github.orionlibs.utilities.abstraction;

import io.github.orionlibs.utilities.object.CloningService;

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