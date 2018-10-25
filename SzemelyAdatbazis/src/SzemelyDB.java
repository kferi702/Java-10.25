import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SzemelyDB {
	final String JDBC_DRIVER = "org.sqlite.JDBC";
	final String URL = "jdbc:sqlite:Szemely.db";
	
	Connection conn = null;
	Statement createStatement = null;
	DatabaseMetaData dbmd = null;
	
	public SzemelyDB() {
		try {
			conn = DriverManager.getConnection(URL);
			System.out.println("A kapcsolat létrejött az adatbázissal!");
		} catch (SQLException e) {
			System.err.println("Valami baj van a kapcsolat létrehozásakor!" + e);
		}
		
		// Megnézzük, hogy üres-e az adatbázis!
		if(conn != null) {
			try {
				createStatement = conn.createStatement();
			} catch (SQLException e) {
				System.err.println("Valami baj van createStatement létrehozásakor!" + e);
			}
		}
		
	}
	
	public void showAllSzemely() {
		String sql = "SELECT * FROM szemely";
		try {
			ResultSet rs = createStatement.executeQuery(sql);
			while (rs.next()) {
				String id = rs.getString("id");
				String vezeteknev = rs.getString("vezeteknev");
				String keresztnev = rs.getString("keresztnev");
				String szuldatum = rs.getString("szuldatum");
				System.out.println(id + " | " + vezeteknev + " | " + 
								   keresztnev + " | " +  szuldatum);
			}
		} catch (SQLException e) {
			System.err.println("Hiba a szemelyek kiolvasásakor!" + e);
		}
	}
	public void addSzemely(String vnev, String knev, String szuld) {
		String sql ="INSERT INTO szemely (vezeteknev, keresztnev, szuldatum) VALUES (?,?,?)";
		try {
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setString(1, vnev);
			ps.setString(2, knev);
			ps.setString(3, szuld);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("Hiba a szemely Felvételekor! " + e);
		}
		
	}

	public void removeSzemely(String id) {
		String sql ="DELETE FROM szemely WHERE id = ?";
		try {
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("Hiba a szemelyek törlésekor! " + e);
		}
		
	}

	public void updateSzemely(String id, String veznev, String kernev, String szuld) {
		String sql ="UPDATE szemely SET vezeteknev = ?, keresztnev = ?, szuldatum = ? WHERE id = ?";
		try {
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setString(1, veznev);
			ps.setString(2, kernev);
			ps.setString(3, szuld);
			ps.setString(4, id);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("Hiba a személy frissítésekor! " + e);
		}
		
	}
}
