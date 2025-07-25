package caaiobomfim.application.postcondition;

public class S3ReportGenerator implements ReportGeneratorInterface{
    @Override
    public String generate() {
        return "https://s3.amazonaws.com/mybucket/s3_report_v2Kln5Fy4.txt";
    }
}
