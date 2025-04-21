package Helper;

import Assignment.Student;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class readCSV {
    public static Map<String, Student> csvToMap(String filePath) {
        Map<String, Student> students = new TreeMap<>();
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        // Implement logic to read CSV file and populate the students list
        try {
            br = new BufferedReader(new FileReader(filePath));
            while ((line = br.readLine()) != null) {
                // Tách từng dòng thành mảng các phần tử
                String[] studentData = line.split(cvsSplitBy);
                // Tạo đối tượng Student từ mảng dữ liệu và thêm vào TreeMap
                Student student = new Student(studentData[0], studentData[1], Double.parseDouble(studentData[2]));
                students.put(studentData[0], student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return students;
    }
}
