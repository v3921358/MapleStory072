package server;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Emilyx3
 */
public class ServerProperties {

    private static final Properties props = new Properties();

    private ServerProperties() {
    }

    /*static {
     String toLoad = "channel.properties";
     loadProperties(toLoad);
     if (getProperty("GMS") != null) {
     GameConstants.GMS = Boolean.parseBoolean(getProperty("GMS"));
     }
     try {
     try (PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement("SELECT * FROM auth_server_channel_ip"); ResultSet rs = ps.executeQuery()) {
     while (rs.next()) {
     //if (rs.getString("name").equalsIgnoreCase("gms")) {
     //    GameConstants.GMS = Boolean.parseBoolean(rs.getString("value"));
     //} else {
     props.put(rs.getString("name") + rs.getInt("channelid"), rs.getString("value"));
     //}
     }
     }
     } catch (SQLException ex) {
     System.exit(0); //Big ass error.
     }
     toLoad = GameConstants.GMS ? "worldGMS.properties" : "world.properties";
     loadProperties(toLoad);

     }*/
    public static void loadProperties(String s) {
        FileReader fr;
        try {
            fr = new FileReader(s);
            props.load(fr);
            fr.close();
        } catch (IOException ex) {
        }
    }

    public static String getProperty(String s) {
        return props.getProperty(s);
    }

    public static void setProperty(String prop, String newInf) {
        props.setProperty(prop, newInf);
    }

    public static String getProperty(String s, String def) {
        return props.getProperty(s, def);
    }
}
