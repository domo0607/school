/**
 * @file: Room.java
 * This is the object which encapsulates all access to the DB-table Room.
 * Connection to the DB is taken care of via Session.java.
 * This will not allow you to create new rooms, but it will let you scan
 * the database for whatever exists.
 * Some fields can be updated (price, facilities, etc.).
 * @author: Amritpal 
 * @bugs: note the use of resultSet.next() to advance to the correct result
 * 			as the JDBC driver does not appear to support TYPE_FORWARD_ONLY.
 * 			This means that resultSet.next() must be called immediately after
 * 			the sqlStatement.() otherwise it can time out as well.
 * 		I did not make use of prepared-statements which are quicker
 * 		than the dynamically built ones for fetching by passed parameters.
 * 		There is no explicit call to dbSession.disconnect() ;
 * @link: http://www.tutorialspoint.com/jdbc/jdbc-db-connections.htm
 * 
 *
 */
import java.sql.* ;
import java.util.Date ;


public class Guest
{
	// ----------------------------------------------------------------------
	// Class variables
	// ----------------------------------------------------------------------
	// fields in db-table.
	private int iGuestID ;
	private String szFirstName ;
	private String szSurname ;
	private Date iDOB ;
	private int iHouseNum ;
	private String szStreetName ;
	private String szPostCode ;
	private int iMobile ;
	private String szEmail ;
	private String szGender ;
	private long iCardNumber ;
	
	private int iNumRows ;

	// DB materials.
	private String sql ;
	private String sz ;

	private Statement sqlStatement = null ; 
	private ResultSet resultSet = null ;

	private Session dbSession ;

	// ----------------------------------------------------------------------
	// Constructor
	// ----------------------------------------------------------------------
	public Guest()
	{
		iDOB = new Date() ;
		reset() ;
		this.dbSession = new Session() ;
		dbSession.connect();
		if ( dbSession.isConnected() == false )
		{
			System.err.println( this.getClass().getName() + ":: failed to connect to DB for table." ) ;
		}
		countRows() ;
		return ;
	}

	// ----------------------------------------------------------------------
	// Setters
	// ----------------------------------------------------------------------
	private void reset()
	{
		iGuestID = 0 ;
		szFirstName = null ;
		szSurname = null ;
		// iDOB = Date( "1970-01-01" ) ;
		iHouseNum = 0 ;
		szStreetName = null ;
		szPostCode = null ;
		iMobile = 0 ;
		szEmail = null ;
		szGender = null ;
		iCardNumber = 0 ;
	
		iNumRows = -1 ;		// to spot the difference between empty table & no methods run.
		sz = null ;
		sql = null ;
		sqlStatement = null ;
		resultSet = null ;
		return ;			
	}

	// ----------------------------------------------------------------------
	// to determine how many rows exists in this table.
	// this will allow for fixed-loop iterations instead in other methods
	public int countRows()
	{
		if ( iNumRows < 0 )
		{
			try
			{
				System.err.println( this.getClass().getName()+ ":: DB connected := " + dbSession.isConnected() ) ;
			
				sql = "SELECT count(*) AS rowCount FROM Guest;" ;
				
				sqlStatement = dbSession.getConnection().createStatement() ;
				resultSet = sqlStatement.executeQuery( sql ) ;
				resultSet.next() ;
				
				iNumRows = resultSet.getInt( "rowCount" ) ;
				System.out.println( this.getClass().getName() + ":: Found " + iNumRows + " rows in the DB-table." ) ;
				
				resultSet.close() ;
			}
			catch( SQLException se )
			{
				System.err.println( this.getClass().getName() + ":: SQL error:: " + se ) ;
				se.printStackTrace() ;
			}
			catch ( Exception e )
			{
				System.err.println( this.getClass().getName() + ":: Error:: " + e ) ;
				e.printStackTrace() ;
			}
			finally
			{
			}
		}
		return ( this.iNumRows ) ;
	}

	// ----------------------------------------------------------------------
	// This will collect the primary key if the requested room number exists
	// in the database table.
	// This means the index can be used thereafter.
	public boolean getByCardNumber( int iReqRoom )
	{
		boolean bRC = false ;
		int i ;
		try
		{
			System.err.println( this.getClass().getName()+ ":: DB connected := " + dbSession.isConnected() ) ;
			
			sql = "SELECT GuestID"
					+ ", CardNumber"
					+ " FROM Guest ;" ;

			System.err.println( this.getClass().getName()+ ":: about to exec:= " + sql ) ;
			
			sqlStatement = dbSession.getConnection().createStatement() ;
			resultSet = sqlStatement.executeQuery( sql ) ;
			bRC = resultSet.next() ;
			if ( bRC == true )
			{
				for ( i = 1 ; i <= iNumRows ; i++ )
				{
					if ( resultSet.getLong( "CardNumber" ) == iReqRoom )
					{
						this.iCardNumber = iReqRoom ;
						this.iGuestID = resultSet.getInt( "GuestID" ) ;
						bRC = true ;
					}
					else
					{
						resultSet.next() ;
					}
				}
			}
			else
			{
				System.err.println( this.getClass().getName() + ":: resultSet := " + resultSet ) ;
			}
			
			resultSet.close() ;
		}
		catch( SQLException se )
		{
			System.err.println( this.getClass().getName() + ":: SQL error:: " + se ) ;
			se.printStackTrace() ;
		}
		catch ( Exception e )
		{
			System.err.println( this.getClass().getName() + ":: Error:: " + e ) ;
			e.printStackTrace() ;
		}
		finally
		{
		}
		return ( bRC ) ;
	}


	// ----------------------------------------------------------------------
	// Getters
	// ----------------------------------------------------------------------
	
	// ----------------------------------------------------------------------
	// Allows the entire record to be collected based upon either the RoomId
	// or the RoomNumber fields.
	// Uses a boolean (bId) to determine which mode it is to be set for:
	//		true	- by primary key (RoomId)
	//		false	- by main usage field (RoomNumber)
	public void collectRecord( boolean bId , int input )
	{
		try
		{
			System.err.println( this.getClass().getName()+ ":: DB connected := " + dbSession.isConnected() ) ;
			
			sql = "SELECT GuestID"
					+ ", FirstName"
					+ ", Surname"
					+ ", DOB"
					+ ", HouseNum"
					+ ", StreetName"
					+ ", Postcode"
					+ ", Mobile"
					+ ", Email"
					+ ", Gender"
					+ ", CardNumber" 
					+ " FROM Guest " ;
			
			if ( bId == true )
			{
				// searching by primary key (id)
				sql = sql + " WHERE GuestID = " + input + ";" ;
			}
			
			System.err.println( this.getClass().getName()+ ":: about to exec:= " + sql ) ;
			
			sqlStatement = dbSession.getConnection().createStatement() ;
			resultSet = sqlStatement.executeQuery( sql ) ;
			resultSet.next() ;
			
			iGuestID = resultSet.getInt( "GuestID" ) ;
			szFirstName = resultSet.getString( "FirstName" ) ;
			szSurname = resultSet.getString( "Surname" ) ;
			iDOB = resultSet.getDate( "DOB" ) ;
			iHouseNum = resultSet.getInt( "HouseNum" ) ;
			szStreetName = resultSet.getString( "StreetName" ) ;
			szPostCode = resultSet.getString( "Postcode" ) ;
			iMobile = resultSet.getInt( "Mobile" ) ;
			szEmail = resultSet.getString( "Email" ) ;
			szGender = resultSet.getString( "Gender" ) ;
			iCardNumber = resultSet.getLong( "CardNumber" ) ;
			
			resultSet.close() ;
		}
		catch( SQLException se )
		{
			System.err.println( this.getClass().getName() + ":: SQL error:: " + se ) ;
			se.printStackTrace() ;
		}
		catch ( Exception e )
		{
			System.err.println( this.getClass().getName() + ":: Error:: " + e ) ;
			e.printStackTrace() ;
		}
		finally
		{
		}
		return ;
	}

	// ----------------------------------------------------------------------
	// to use the PK.
	public void collectRecordByGuestID( int id )
	{
		collectRecord( true , id ) ;
		return ;
	}
	
	// ----------------------------------------------------------------------
	// to use the main field.
	public void collectRecordByCarNumber( int id )
	{
		collectRecord( false , id ) ;
		return ;
	}
	
	// ----------------------------------------------------------------------
	// utilities
	// ----------------------------------------------------------------------
	public void display()
	{
		sz = "::display()" ;
		sz = sz + "\n\tGuestID := " + iGuestID ;
		sz = sz + "\n\tFirstName := " + szFirstName ;
		sz = sz + "\n\tSurname := " + szSurname ;
		sz = sz + "\n\tDOB := " + iDOB ;
		sz = sz + "\n\tHouseNum := " + iHouseNum ;
		sz = sz + "\n\tStreetName := " + szStreetName ;
		sz = sz + "\n\tPostcode := " + szPostCode ;
		sz = sz + "\n\tMobile := " + iMobile ;
		sz = sz + "\n\tEmail := " + szEmail ;
		sz = sz + "\n\tGender := " + szGender ;
		sz = sz + "\n\tCardNumber := " + iCardNumber ;
		System.out.println( this.getClass().getName() + sz ) ;
		return ;
	}
	
	// ----------------------------------------------------------------------
	// test rig
	// ----------------------------------------------------------------------
	public static void main( String [] args )
	{
		Guest Guest = new Guest() ;
		
		Guest.collectRecordByGuestID( 1 ) ;
		Guest.display() ;
		
		Guest.collectRecordByGuestID( 2 ) ;
		Guest.display() ;
		
		Guest.collectRecordByCarNumber( 01234567 );
		Guest.display() ;
		return ;
	}
	
}
