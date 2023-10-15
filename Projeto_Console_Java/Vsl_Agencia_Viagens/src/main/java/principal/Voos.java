package principal;

import java.util.Date;

public class Voos {

    private int vooID;
    private String piloto;
    private Date data_ida;
    private Date data_volta;
    public Voos(String piloto, Date data_ida, Date data_volta) {
        this.piloto = piloto;
        this.data_ida = data_ida;
        this.data_volta = data_volta;
    }
    public Voos() {

    }
    public int getVooID() {
        return vooID;
    }

    public void setVooID(int vooID) {
        this.vooID = vooID;
    }

    public String getPiloto() {
        return piloto;
    }

    public void setPiloto(String piloto) {
        this.piloto = piloto;
    }

    public Date getData_ida() {
        return data_ida;
    }

    public void setData_ida(Date data_ida) {
        this.data_ida = data_ida;
    }

    public Date getData_volta() {
        return data_volta;
    }

    public void setData_volta(Date data_volta) {
        this.data_volta = data_volta;
    }





}
    //vooID serial primary key,
    //piloto varchar(100) not null,
       // data_ida timestamp not null,
       // data_volta timestamp not null