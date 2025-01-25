package io.github.orionlibs.utilities.compression;

import io.github.orionlibs.utilities.compression.zip.ZIPCompressionService;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Set;

public class CompressionService
{
    public static void compressToZIPAsStream(String tempFolder, Set<File> filesToCompress, OutputStream output, boolean deleteFilesAfterCompression) throws IOException
    {
        ZIPCompressionService.compressAsStream(tempFolder, filesToCompress, output, deleteFilesAfterCompression);
    }
}