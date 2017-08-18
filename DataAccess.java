import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataAccess {

	public static void main(String[] args){

		DataAccess dataAccess = new DataAccess();

		try{

			dataAccess.selectOracle();
		
		}catch(Exception e){
		
			e.printStackTrace();
		
		}

	}



public void selectOracle() throws Exception{

		//ユーザ名	
		String user = "SYS as sysdba";

		//パスワード
		String pass = "oracle";

		//サーバ名
		String servername = "127.0.0.1";

		//SID
		String sid = "orcl";

		Connection conn = null;
		Statement stmt = null;
		ResultSet result = null;

		try{
			//ドライバクラスのロード
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//Connectionの作成
			
			conn = DriverManager.getConnection 
		("jdbc:oracle:thin:@" + servername + ":1521:" + sid, user , pass);
			
			//Statementの作成
			stmt = conn.createStatement();

			//Resultsetの作成
			result = stmt.executeQuery("SELECT 商品ID, 商品名, グループ名, 仕入単価, 卸単価 FROM 商品マスタ");

			//取得したデータを表示
			while(result.next()){
				System.out.print(result.getString(1) + " ");
				System.out.print(result.getString(2) + " ");
				System.out.print(result.getString(3) + " ");
				System.out.print(result.getString(4) + " ");
				System.out.println(result.getString(5) + " ");
				
			}

		}catch(ClassNotFoundException e){
			throw e;

		}catch(SQLException e){
			throw e;
		}catch(Exception e){
			throw e;
		}
		finally{
			//クローズ処理
			if(conn != null){
				conn.close();
				conn = null;
			}
			if(stmt != null){
				stmt.close();
				stmt = null;
			}
			if(result != null){
				result.close();
				result = null;
			}
		}
		
	}
}