import javafx.scene.control.Button;

public class Program {
    private String name;
    private Float ramUsage;
    private Integer ppid;
    private Float cpuUsage;
    Button btn;

    public Program(String name, Float ramUsage, Integer ppid, Float cpuUsage){
        this.name = name;
        this.ramUsage = ramUsage;
        this.ppid = ppid;
        this.cpuUsage = cpuUsage;
    }

    public Float getCpuUsage() {
        return cpuUsage;
    }

    public Integer getPpid() {
        return ppid;
    }

    public Float getRamUsage() {
        return ramUsage;
    }

    public String getName() {
        return name;
    }

    public Button getButton() {
        this.btn = new Button("Kill");
        this.btn.setOnAction(event -> {
            System.out.println("BTNMPRES");
        });
        return btn;
    }

}
