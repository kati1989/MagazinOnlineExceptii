package model;

public class Administrator extends Costumer {
    //pe ce product este aministrator
    public String categorie;

    public Administrator() {
    }

    public Administrator(int id,
                         String email,
                         String password,
                         String fullName,
                         String billigAdress,
                         String type,
                         String categorie) {
        super(id, email, password, fullName, billigAdress, type);
        this.categorie = categorie;
    }

    public Administrator(String proprietati) {
        super(Integer.parseInt(proprietati.split(",")[0]), proprietati.split(",")[1], proprietati.split(",")[2], proprietati.split(",")[3], proprietati.split(",")[4], proprietati.split(",")[5]);
        this.categorie = proprietati.split(",")[6];
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    @Override
    public String descriere() {
        String desc = "";
        desc += "\nId: " + super.getId() + "\nEmail: " + super.getEmail() + "\nPassword: " + super.getPassword() + "\nFull Name: " + super.getFullName() + "\nBilling Adress: " + super.getBillingAdress() + "\nType" + super.getType() + "\nCategorie: " + categorie;
        return desc;
    }

    @Override
    public String toString() {
        String text = "";
        text += super.getId() + "," + super.getEmail() + "," + super.getPassword() + "," + super.getFullName() + "," + super.getBillingAdress() + "," + type + "," + categorie;
        return text;
    }
}
