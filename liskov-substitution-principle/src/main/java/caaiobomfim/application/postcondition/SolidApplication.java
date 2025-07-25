package caaiobomfim.application.postcondition;

import java.io.File;

public class SolidApplication {
    public static void main(String[] args) {
        process(new CSVReportGenerator());
    }

    public static void process(ReportGeneratorInterface reportGeneratorInterface){
        String path = reportGeneratorInterface.generate();
        File archive = new File(path);
        if (!archive.exists()){
            throw new IllegalArgumentException("The file not exists");
        }
        // LOGIC FOR PROCESS THE FILE
    }
}