  
import java.util.List;

public interface ProfessorDirectory {
    void addNewProfessor(String professorName);
    void addNewProfessor(String professorName, Integer classNumber);
    void addClassToProfessor(String professorName, Integer classNumber);
    List<Integer> getClassesForProfessor(String professorName) throws IllegalArgumentException;
    boolean removeProfessor(String professorName);
    boolean containsProfessor(String professorName);
}