#if (${PACKAGE_NAME} && ${PACKAGE_NAME} != "")package ${PACKAGE_NAME};

import static problem.Solution.problem;

#end
#parse("File Header.java")
public class ${NAME} {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=
        problem("", () -> 
            solution());
    }
}
