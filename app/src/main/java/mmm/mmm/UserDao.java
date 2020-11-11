package mmm.mmm;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * FROM user")
    LiveData<List<User>> getAll();


    @Insert()
    public void insert(User user);


    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
    LiveData<List<User>> loadAllByIds(int[] userIds);


    @Query("SELECT * FROM user WHERE prenom LIKE :first AND " +
            "nom LIKE :last LIMIT 1")
    User findByName(String first, String last);

    @Insert
    void insertAll(User... users);


    @Delete
    void delete(User user);

    @Delete
    void deleteAll(User... users);
}
