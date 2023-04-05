package ApiRestwithRDS.Exceptions;

public class EmployeeNotFoundExceptionHateoas extends RuntimeException{


    public EmployeeNotFoundExceptionHateoas(Long id){
        super("Could not find the id:" +id);
    }
}
