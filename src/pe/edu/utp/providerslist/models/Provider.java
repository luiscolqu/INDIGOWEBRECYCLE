package pe.edu.utp.providerslist.models;

/**
 * Created by Administrador on 03/03/2017.
 */
public class Provider {
    private int id;
    private String name;
    private String waste;
    private String process;
    private int fullrequest;
    private int pendrequest;

    public Provider(int id, String name, String waste, String process, int fullrequest, int pendrequest) {
        this.setId(id);
        this.setName(name);
        this.setWaste(waste);
        this.setProcess(process);
        this.setFullrequest(fullrequest);
        this.setPendrequest(pendrequest);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWaste() {
        return waste;
    }

    public void setWaste(String waste) {
        this.waste = waste;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public int getFullrequest() {
        return fullrequest;
    }

    public void setFullrequest(int fullrequest) {
        this.fullrequest = fullrequest;
    }

    public int getPendrequest() {
        return pendrequest;
    }

    public void setPendrequest(int pendrequest) {
        this.pendrequest = pendrequest;
    }
}
