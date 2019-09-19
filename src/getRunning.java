import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class getRunning {
    public static void main(String[] args) {
        runGetRunning();
    }

    public static void runGetRunning(){
        ArrayList<String[]> running = new ArrayList<>();
        try {
            String cmd = "ps x -e -o pid,%mem,%cpu,comm=";
            Process p = Runtime.getRuntime().exec(cmd);
            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line = input.readLine();
            Boolean first = false;
            while((line = input.readLine()) != null) {
                String[] splitString = line.split(" ");
//                if(getLength(splitString)) {
                String[] prgm = new String[4];
                int i = 0;
                for(String j : splitString) {
                    if(!j.equals("") && first) {
                        prgm[i] = j;
                        i++;
                    }
//                    }
                }
                running.add(prgm);
                first = true;
            }
            input.close();
            for (String[] abcdefg:running) {
                for (String item:abcdefg) {
                    System.out.print(item);
                    System.out.print(", ");
                }
                System.out.println();

            }
        }
        catch(Exception err) {
            err.printStackTrace();
        }

        String ppid;
        String name;
        String ram;
        String cpu;
        for(String[] str:running) {
            ppid = str[0];
//            System.out.println(ppid);
            name = str[3];
//            System.out.println(name);
            ram = str[1];
//            System.out.println(ram);
            cpu = str[2];
//            System.out.println(cpu);
            if((name != null)&&(ppid != null)&&(ram != null)&&(cpu != null)) {
                Program prgm = new Program(name, Float.parseFloat(ram), Integer.parseInt(ppid), Float.parseFloat(cpu));
                TableViewHelper.addToProgramList(prgm);
            }
        }
    }
    
//    private static void getLength(String[] array){
//        ArrayList<String> rryLst = new ArrayList<>();
//        for(String i:array) {
//            if(!i.equals("")){
//                rryLst.add(i);
//            }
//        }
//        if(rryLst.)
//    }
}