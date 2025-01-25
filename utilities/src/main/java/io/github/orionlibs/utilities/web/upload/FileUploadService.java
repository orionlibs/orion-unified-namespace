package io.github.orionlibs.utilities.web.upload;

import io.github.orionlibs.utilities.abstraction.OrionService;
import java.io.InputStream;
import jakarta.servlet.http.HttpServletResponse;

public class FileUploadService extends OrionService
{
    public static void uploadFileToServletResponse(HttpServletResponse response, String MIMEType, String fileNameForClient, String fileLocation)
    {
        FileUploaderToServletResponse.builder()
                        .response(response)
                        .MIMEType(MIMEType)
                        .fileNameForClient(fileNameForClient)
                        .fileLocation(fileLocation)
                        .build()
                        .upload();
    }


    public static void uploadStreamToServletResponse(HttpServletResponse response, String MIMEType, String fileNameForClient, InputStream stream)
    {
        StreamUploaderToServletResponse.builder()
                        .response(response)
                        .MIMEType(MIMEType)
                        .fileNameForClient(fileNameForClient)
                        .stream(stream)
                        .build()
                        .upload();
    }


    public static void uploadTextToServletResponse(HttpServletResponse response, String MIMEType, String fileNameForClient, String contentToUpload)
    {
        TextUploaderToServletResponse.builder()
                        .response(response)
                        .MIMEType(MIMEType)
                        .fileNameForClient(fileNameForClient)
                        .contentToUpload(contentToUpload)
                        .build()
                        .upload();
    }
}