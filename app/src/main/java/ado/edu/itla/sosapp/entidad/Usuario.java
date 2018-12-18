
package ado.edu.itla.sosapp.entidad;

public class Usuario {
<<<<<<< HEAD
    public int id;
=======

    private int id;
>>>>>>> 9e5982be5e8582d1de3c6e89ffd266810b9df116
    private String nombre;
    private String password;
    private String email;

<<<<<<< HEAD

=======
>>>>>>> 9e5982be5e8582d1de3c6e89ffd266810b9df116
    public int getId() {
        return id;
    }

<<<<<<< HEAD
    public String getNombre() {
        return nombre;
    }


    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
=======
    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
>>>>>>> 9e5982be5e8582d1de3c6e89ffd266810b9df116
    }

    public void setPassword(String password) {
        this.password = password;
    }

<<<<<<< HEAD
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
=======
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

>>>>>>> 9e5982be5e8582d1de3c6e89ffd266810b9df116
}
