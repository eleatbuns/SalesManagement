package model;

import com.jfinal.plugin.activerecord.Model;

public class Administrator extends Model<Administrator> {
    public static final Administrator dao = new Administrator().dao();
}
