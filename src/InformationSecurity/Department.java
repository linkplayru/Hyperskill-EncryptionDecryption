package InformationSecurity;

import algorithms.*;
import enums.Mode;
import utils.Arguments;

public class Department {

    public static Specialist train(Arguments arg) {
        Algorithm algorithm = null;
        if (arg.getMode() == Mode.ENCODE) {
            if (arg.getAlgorithm() == enums.Algorithm.SHIFT) {
                algorithm = new ShiftEncode(arg.getKey());
            } else if (arg.getAlgorithm() == enums.Algorithm.UNICODE) {
                algorithm = new UnicodeEncode(arg.getKey());
            }
        } else if (arg.getMode() == Mode.DECODE) {
            if (arg.getAlgorithm() == enums.Algorithm.SHIFT) {
                algorithm = new ShiftDecode(arg.getKey());
            } else if (arg.getAlgorithm() == enums.Algorithm.UNICODE) {
                algorithm = new UnicodeDecode(arg.getKey());
            }
        }
        return new Specialist(algorithm, arg.getData(), arg.getOut(), arg.getFile());
    }

}
