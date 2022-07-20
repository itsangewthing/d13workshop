package sg.edu.nus.iss.d13workshop.services;

import java.io.*;
import java.nio.file.*;
import java.util.*;

import org.springframework.stereotype.Service;


@Service
public class DatabaseService {

    private File dataDir = new File("some directory");
   
    //getter
    public File getDataDir(){
        return dataDir;
    }

    //setter
    public void setDataDir(File dataDir) {this.dataDir = dataDir;}

    // /
    public boolean isDataDirValid(){
        return dataDir.exists() && dataDir.isDirectory() && dataDir.canWrite();

    }

    public boolean save(){return false;}

	public void read(String fileId) {
		
	}
    
}
