package com.intercom.filesort.constants;

public class AppConstant {
    public static final String FILE_PATH_PREFIX = "/Users/mmt7465/Downloads/SortFile";

    public static String INPUT_FILE_NAME = FILE_PATH_PREFIX + "/src/main/resources/customer.txt";
    public static final String TEST_INPUT_FILE_EMPTY = FILE_PATH_PREFIX + "/src/main/resources/customer-test-empty-file.txt";
    public static final String TEST_INPUT_FILE_DOES_NOT_EXISTS = FILE_PATH_PREFIX + "/src/main/resources/customer-test-file-does-not-exist.txt";
    public static final String TEST_INPUT_FILE_INVALID = FILE_PATH_PREFIX + "/src/main/resources/customer-test-invalid-input.txt";


    public static final String OUTPUT_FILE_NAME = FILE_PATH_PREFIX + "/src/main/resources/output.txt";

    public static final double DUBLIN_LATITUDE = 53.339428d;
    public static final double DUBLIN_LONGITUDE = -6.257664d;
    public static final double DUBLIN_LATITUDE_IN_RADIAN = 0.930948639728d;
    public static final double DUBLIN_LONGITUDE_IN_RADIAN = -0.10921684028d;
    public static final double SINE_FUNCTION_DUBLIN_LATITUDE = Math.sin(DUBLIN_LATITUDE_IN_RADIAN);
    public static final double COSINE_FUNCTION_DUBLIN_LATITUDE = Math.cos(DUBLIN_LATITUDE_IN_RADIAN);



    public static final String TEMP_FILE = "temp-file-";
    public static final int EARTH_RADIUS_IN_KM = 6371;
    public static final int DISTANCE_LIMIT = 100;
    public static long TEMP_FILE_SIZE = 10000l;
}
