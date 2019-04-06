package org.AHJ.controllers.Filhåndtering;

import java.io.File;
import java.io.FilenameFilter;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

public abstract class LastFil {



    private void setdefault(){

        URL location = LastFil.class.getProtectionDomain().getCodeSource().getLocation();
        location.getPath();
    }


}
