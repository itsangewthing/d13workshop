package sg.edu.nus.iss.d13workshop;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ch.qos.logback.core.util.SystemInfo;
import sg.edu.nus.iss.d13workshop.services.DatabaseService;


@SpringBootApplication
public class D13workshopApplication implements ApplicationRunner {

	//automatically instantiates the functions
	@Autowired
	DatabaseService dbSvc;
	public static void main(String[] args) {
		SpringApplication.run(D13workshopApplication.class, args);
		
	}

	@Override
	public void run(ApplicationArguments args) {
		if (args.containsOption("dataDir")){
			final String dataDir = args.getOptionValues("dataDir").get(0);
			dbSvc.setDataDir(new File(dataDir));

			if (!dbSvc.isDataDirValid()){
				System.out.printf("%s does not exist, is not a driectory or not writable.");
				System.exit(-1);
			}

			System.out.printf("using %s as data directory \n", dataDir);
		}else{
			// setting this as a default location to read the file
			dbSvc.setDataDir(new File("./data"));
		}
		
	}
 
}
