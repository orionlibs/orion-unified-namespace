package io.github.orionlibs.utilities.compression.zip;

import io.github.orionlibs.utilities.abstraction.OrionService;
import io.github.orionlibs.utilities.file_system.file.FileService;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZIPCompressionService extends OrionService
{
    public static void compressAsStream(String tempFolder, Set<File> filesToCompress, OutputStream output, boolean deleteFilesAfterCompression) throws IOException
    {
        ZipOutputStream zos = new ZipOutputStream(output);

        for(File file : filesToCompress)
        {
            ZipEntry zipEntry = new ZipEntry(file.getName());
            zos.putNextEntry(zipEntry);
            zos.write(Files.readAllBytes(file.toPath()));
            zos.closeEntry();
        }

        zos.finish();

        if(deleteFilesAfterCompression)
        {

            for(File fileToDelete : filesToCompress)
            {

                try
                {
                    FileService.deleteFile(fileToDelete);
                }
                catch(IOException e)
                {
                }

            }

        }

    }
}