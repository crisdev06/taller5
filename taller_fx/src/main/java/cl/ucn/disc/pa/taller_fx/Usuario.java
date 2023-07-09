package cl.ucn.disc.pa.taller_fx;

public class Usuario {

    //rut, name, lastname, password

    private String rut;
    private String name;
    private String lastName;

    private String password;

    public Usuario(String rut, String name, String lastName, String password) {
        this.rut = rut;
        this.name = name;
        this.lastName = lastName;
        this.password = password;
    }

    public String getRut() {
        return rut;
    }



    public String getName() {
        return name;
    }



    public String getLastName() {
        return lastName;
    }


    public String getPassword() {
        return password;
    }


}
