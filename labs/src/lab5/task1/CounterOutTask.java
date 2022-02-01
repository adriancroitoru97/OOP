package lab5.task1;

public class CounterOutTask implements Task {
    public static int contor = 0;

    @Override
    public void execute() {
        contor++;
        System.out.println(contor);
    }
}
