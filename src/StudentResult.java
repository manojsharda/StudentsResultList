import model.StudentInfo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class StudentResult {

    public static void main(String[] args) {

        StudentResult studentInfoList = new StudentResult();
        List<StudentInfo> sl = new ArrayList();
        String fileName = "files/unsort.txt";

        try{
            String filepath = StudentResult.class.getResource("/").getFile() +fileName;
            File file = new File(filepath);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String str = null;
            int id_1 = 0;
            float gpa_1 = 0;
            bufferedReader.readLine();
            System.out.println("Input: ");

            //read data then split them
            while((str=bufferedReader.readLine())!=null){
                String[] array;
                array = str.split("\\s+");
                System.out.println(array[0] + " " + array[1]+ " " + array[2]);
                try{
                    id_1 = Integer.parseInt(array[0]);
                    gpa_1 = Float.parseFloat(array[2]);
                }catch(NumberFormatException ne){
                    id_1 = 0;
                    gpa_1 = 0;
                }
                StudentInfo si = new StudentInfo(id_1,array[1],gpa_1);
                sl.add(si);

            }
            bufferedReader.close();

            sl.sort(studentInfoList.new StudentResultComparator());

            System.out.println("Output: ");
            Iterator it = sl.iterator();
            while(it.hasNext()){
                StudentInfo si1 = (StudentInfo)(it.next());
                System.out.println(si1.getFirstName());
            }

        }catch(IOException e) {
            System.out.println(e.getMessage());

        }

    }//end of main()
    /**
     * implement Comparator
     * arrange the list according to GPA in descending order,
     * if same GPA, arrange according to in alphabetical order,
     * if same first name, arrange according to ID in ascending order.
     */
    class StudentResultComparator implements Comparator <StudentInfo>
    {
        @Override
        public int compare(StudentInfo si1, StudentInfo si2)
        {
            if(si1.getGpa() > si2.getGpa()) return -1;
            else if(si1.getGpa() == si2.getGpa()){
                if(si1.getFirstName().compareTo(si2.getFirstName()) < 0)
                    return -1;
                else if(si1.getFirstName().compareTo(si2.getFirstName()) == 0){
                    if(si1.getID() < si2.getID()) return -1;
                    else return 1;
                }
                else return 1;
            }
            else return 1;
        }


    }//end of StudentInfoComparator

}//end of StudentResult class

