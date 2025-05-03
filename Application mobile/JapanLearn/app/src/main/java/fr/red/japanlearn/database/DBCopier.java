package fr.red.japanlearn.database;

import android.content.Context;

import androidx.annotation.NonNull;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@SuppressWarnings({ "SpellCheckingInspection", "unused", "SdCardPath" })
public class DBCopier {

    private final String path;
    private final String fileName;
    private final Context context;

    public DBCopier(final String fileName, @NonNull final Context context) {
        this.fileName = fileName;
        this.path = "/data/data/" + context.getPackageName() + "/databases/";
        this.context  = context;
    }

    private void copyStream(@NonNull InputStream input, OutputStream output) throws IOException
    {
        byte[] buffer = new byte[1024];
        int length;
        while((length = input.read(buffer)) > 0)
        {
            output.write(buffer, 0, length);
        }
    }

    private void closeStreams(OutputStream output, InputStream input)
    {
        if(output != null)
        {
            try
            {
                output.close();
            }
            catch(IOException ignored)
            {
            }
        }
        if(input != null)
        {
            try
            {
                input.close();
            }
            catch(IOException ignored) {
            }
        }
    }

    public void checkDatabase()
    {
        File fichierBaseDeDonnes = new File(path + fileName);
        try
        {
            if(!fichierBaseDeDonnes.exists())
            {
                copyDatabase(context.getAssets().open(fileName), fichierBaseDeDonnes);
            }
        }
        catch(Exception ignored)
        {
        }
    }

    public void copyDatabase(InputStream source, File destination) throws IOException
    {
        InputStream  input  = null;
        OutputStream output = null;
        try
        {
            new File(path).mkdirs();
            input  = new BufferedInputStream(source);
            output = new BufferedOutputStream(new FileOutputStream(destination));
            copyStream(input, output);
        }
        finally
        {
            closeStreams(output, input);
        }
    }
}
