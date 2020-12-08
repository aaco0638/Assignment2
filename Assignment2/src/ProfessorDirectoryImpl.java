import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class ProfessorDirectoryImpl implements ProfessorDirectory {

    private HashMap<String, List<Integer>> professorMap = new HashMap<String, List<Integer>>();
    private List<Integer> classes = new ArrayList<Integer>();
    
    @Override
    public void addNewProfessor(String professorName) {
    	this.classes = new ArrayList<Integer>();
        if(!containsProfessor(professorName))
            professorMap.put(professorName,this.classes);
    }

    @Override
    public void addNewProfessor(String professorName, Integer classNumber) {
        addNewProfessor(professorName); // add name if doesnt exist

        
        List classList = professorMap.get(professorName); //updating list of prof
        classList.add(classNumber);
        professorMap.put(professorName, classList);
    }

    @Override
    public void addClassToProfessor(String professorName, Integer classNumber) {
       
        addNewProfessor(professorName, classNumber);//adds class to new prof
    }

    @Override
    public List getClassesForProfessor(String professorName) throws IllegalArgumentException {
        if(!containsProfessor(professorName))
            throw new IllegalArgumentException("professor name is not in the directory");//if name does not exist throw illegal exception

        return professorMap.get(professorName);
    }

    @Override
    public boolean removeProfessor(String professorName) {
        if(!containsProfessor(professorName))//if doesnt exit return false
            return false;

        
        professorMap.remove(professorName);
        return true; //remove prof name,return false
    }

    @Override
    public boolean containsProfessor(String professorName) {
        return professorMap.containsKey(professorName);// return if prof name exists
    }
}