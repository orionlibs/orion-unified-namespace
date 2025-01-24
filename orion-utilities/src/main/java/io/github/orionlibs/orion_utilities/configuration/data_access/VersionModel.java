package io.github.orionlibs.orion_utilities.configuration.data_access;

import io.github.orionlibs.orion_utilities.abstraction.OrionModel;
import io.github.orionlibs.orion_utilities.object.CloningService;
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
public class VersionModel implements OrionModel
{
    private String version;
    private String majorVersion;
    private String minorVersion;
    private String patchVersion;


    public static VersionModel of()
    {
        return VersionModel.builder().build();
    }


    @Override
    public VersionModel clone()
    {
        return (VersionModel)CloningService.clone(this);
    }


    @Override
    public VersionModel getCopy()
    {
        return this.clone();
    }
}