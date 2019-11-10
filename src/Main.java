import InformationSecurity.Department;
import InformationSecurity.Specialist;
import utils.Arguments;

public class Main {

    public static void main(String[] args) {

        Arguments arg = Arguments.read(args);

        Specialist specialist = Department.train(arg);

        specialist.doWork();

    }

}
