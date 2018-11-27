package pe.com.vitucheando.logging.command;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Created by vitucheando on 26/11/2018.
 */
public enum Commands {
    LOGGING("\\b(loggingTo)\\s?(FILE|CONSOLE|DATABASE)?$"),
    UNKNOWN("");

    Pattern pattern = null;
    Matcher matcher = null;

    private String commandline;
    private String regex;
    private List<String> methods = new ArrayList();

    private Commands(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return this.regex;
    }

    public String getCommandLine() {
        return this.commandline;
    }

    public boolean validateCommandLine(String cmdline)
    {
        this.commandline = cmdline;

        this.pattern = Pattern.compile(getRegex());
        this.matcher = this.pattern.matcher(cmdline);

        if (this.matcher.lookingAt()) {
            return true;
        }
        return false;
    }

    public List<String> getMethods()
    {
        switch (this) {
            case LOGGING:
                System.out.println("COMANDO: LOGGING");
                this.methods = getMethodList("loggingTo");
                break;
            case UNKNOWN:
                System.out.println("COMANDO: UNKNOWN");
                this.methods = null;
                break;
        }
        return this.methods;
    }

    private List<String> getMethodList(String methodName)
    {
        List objects = new ArrayList();
        Pattern pattern = Pattern.compile("(FILE|CONSOLE|DATABASE)");
        Matcher matcher = pattern.matcher(getCommandLine());
        while (matcher.find()) {
            System.out.println("Metodo: " + methodName + Character.toUpperCase(matcher.group().charAt(0)) + matcher.group().toLowerCase().substring(1));
            objects.add(methodName + Character.toUpperCase(matcher.group().charAt(0)) + matcher.group().toLowerCase().substring(1));
        }
        return objects;
    }
}
