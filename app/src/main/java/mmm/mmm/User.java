package mmm.mmm;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity

public class User {

    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "nom")
    public String nom;

    @ColumnInfo(name = "prenom")
    public String prenom;

    @ColumnInfo(name = "date")
    public String date;

    @ColumnInfo(name = "ville")
    public String ville;

    public User(String nom, String prenom, String date, String ville) {
        this.nom = nom;
        this.prenom = prenom;
        this.date = date;
        this.ville = ville;
    }
}