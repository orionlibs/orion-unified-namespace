package io.github.orionlibs.orion_utilities.web.urls;

import io.github.orionlibs.orion_utilities.abstraction.Orion;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import lombok.Builder;

// @NoArgsConstructor
// @AllArgsConstructor
@Builder
//@Getter
//@Setter
class URLDecoder extends Orion
{
    String decodeWithUTF8(String url)
    {

        try
        {
            return java.net.URLDecoder.decode(url, StandardCharsets.UTF_8.name());
        }
        catch(UnsupportedEncodingException e)
        {
            return "";
        }

    }
}