package sg.edu.nus.iss.d13workshop.models;

import java.util.UUID;

public class Contact {
    private final String id;
    private String name; //gs
    private String email; //gs
    private String phone; //gs

    public String getId() {return id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    public String getPhone() {return phone;}
    public void setPhone(String phone) {this.phone = phone;}

    public Contact() {
        this.id = UUID.randomUUID().toString().substring(0, 8);
    }

    public Contact(String id){this.id = id;}


    @Override
    public String toString() {
        return "Contact [email=" + email + ", id=" + id + ", name=" + name + ", phone=" + phone + "]";
    }

    


}
