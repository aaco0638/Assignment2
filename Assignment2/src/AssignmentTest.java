import java.util.List;

public class AssignmentTest{

    private final static String RYBA_NAME = "Alex Ryba";
    private final static String WAXMAN_NAME = "Jerry Waxman";
    private final static String XIANG_NAME = "Zhigang Xiang";
    private final static String GOSWAMI_NAME = "Mayank Goswami";
    public static void main (String args[]){
        int correctResponseCount = 0;
        List<Integer> classesForRyba;
        List<Integer> classesForWaxman;
        List<Integer> classesForXiang;
        List<Integer> classesForGoswami;

        ProfessorDirectory professorDirectory = new ProfessorDirectoryImpl();

        professorDirectory.addNewProfessor(RYBA_NAME);
        classesForRyba = professorDirectory.getClassesForProfessor(RYBA_NAME);
        if(classesForRyba.size() == 0) {
            System.out.println("Test 1 passed");
            correctResponseCount++;
        } 

        if(professorDirectory.containsProfessor(RYBA_NAME)) {
            System.out.println("Test 2 passed");
            correctResponseCount++;
        }

        professorDirectory.addClassToProfessor(RYBA_NAME, 111);
        professorDirectory.addClassToProfessor(RYBA_NAME, 313);
        classesForRyba = professorDirectory.getClassesForProfessor(RYBA_NAME);
        if(classesForRyba.size() == 2) {
            System.out.println("Test 3 passed");
            correctResponseCount++;
        } 

        professorDirectory.addNewProfessor(WAXMAN_NAME, 211);
        classesForWaxman = professorDirectory.getClassesForProfessor(WAXMAN_NAME);
        if(classesForWaxman.size() == 1) {
            System.out.println("Test 4 passed");
            correctResponseCount++;
        }

        professorDirectory.addNewProfessor(WAXMAN_NAME, 381);
        classesForWaxman = professorDirectory.getClassesForProfessor(WAXMAN_NAME);
        if(classesForWaxman.size() == 2) {
            System.out.println("Test 5 passed");
            correctResponseCount++;
        }

        try{
            classesForXiang = professorDirectory.getClassesForProfessor(XIANG_NAME);
        }catch(Exception e) {
            //should throw an exception
            System.out.println("Test 6 passed");
            correctResponseCount++;
        }

        if(!professorDirectory.containsProfessor(XIANG_NAME)){
            //should return false
            System.out.println("Test 7 passed");
            correctResponseCount++;
        }

        professorDirectory.addClassToProfessor(XIANG_NAME, 381);
        classesForXiang = professorDirectory.getClassesForProfessor(XIANG_NAME);
        if(classesForXiang.size() == 1) {
            System.out.println("Test 8 passed");
            correctResponseCount++;
        }

        if(!professorDirectory.removeProfessor(GOSWAMI_NAME)) {
            //should return false
            System.out.println("Test 9 passed");
            correctResponseCount++;
        }

        professorDirectory.addNewProfessor(GOSWAMI_NAME);
        classesForGoswami = professorDirectory.getClassesForProfessor(GOSWAMI_NAME);
        if(classesForGoswami.size() == 0) {
            System.out.println("Test 10 passed");
            correctResponseCount++;
        }

        professorDirectory.addClassToProfessor(GOSWAMI_NAME, 323);
        classesForGoswami = professorDirectory.getClassesForProfessor(GOSWAMI_NAME);
        if(classesForGoswami.size() == 1) {
            System.out.println("Test 11 passed");
            correctResponseCount++;
        }

        if(professorDirectory.removeProfessor(GOSWAMI_NAME)) {
            System.out.println("Test 12 passed");
            correctResponseCount++;
        }

        try{
            classesForGoswami = professorDirectory.getClassesForProfessor(GOSWAMI_NAME);
        }catch(Exception e) {
            System.out.println("Test 13 passed");
            correctResponseCount++;
        }

        System.out.println( correctResponseCount + " tests passed out of 13");
    }
}