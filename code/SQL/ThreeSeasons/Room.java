/**
 * @file: Room.java
 * This is the object which encapsulates all access to the DB-table Room.
 * Connection to the DB is taken care of via Session.java.
 * This will not allow you to create new Rooms, but it will let you scan
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


public class Room
{
	// ----------------------------------------------------------------------
	// Class variables
	// ----------------------------------------------------------------------
	// fields in db-table.
	private int iRoomId ;
	private int iRoomNumber ;
	private short iFloor ;
	private int iCost ;
	private char cOccupancy ;
	private boolean bEnsuite ;
	private boolean bMinibar ;
	private boolean bJacuzzi ;
	private boolean bSeaview ;
	private boolean bHoneymoon ;
	private boolean bFamily ;
	private int iNumBeds ;

	public int getiRoomId() {
		return iRoomId;
	}

	public void setiRoomId(int iRoomId) {
		this.iRoomId = iRoomId;
	}

	public int getiRoomNumber() {
		return iRoomNumber;
	}

	public void setiRoomNumber(int iRoomNumber) {
		this.iRoomNumber = iRoomNumber;
	}

	public short getiFloor() {
		return iFloor;
	}

	public void setiFloor(short iFloor) {
		this.iFloor = iFloor;
	}

	public int getiCost() {
		return iCost;
	}

	public void setiCost(int iCost) {
		this.iCost = iCost;
	}

	public char getcOccupancy() {
		return cOccupancy;
	}

	public void setcOccupancy(char cOccupancy) {
		this.cOccupancy = cOccupancy;
	}

	public boolean isbEnsuite() {
		return bEnsuite;
	}

	public void setbEnsuite(boolean bEnsuite) {
		this.bEnsuite = bEnsuite;
	}

	public boolean isbMinibar() {
		return bMinibar;
	}

	public void setbMinibar(boolean bMinibar) {
		this.bMinibar = bMinibar;
	}

	public boolean isbJacuzzi() {
		return bJacuzzi;
	}

	public void setbJacuzzi(boolean bJacuzzi) {
		this.bJacuzzi = bJacuzzi;
	}

	public boolean isbSeaview() {
		return bSeaview;
	}

	public void setbSeaview(boolean bSeaview) {
		this.bSeaview = bSeaview;
	}

	public boolean isbHoneymoon() {
		return bHoneymoon;
	}

	public void setbHoneymoon(boolean bHoneymoon) {
		this.bHoneymoon = bHoneymoon;
	}

	public boolean isbFamily() {
		return bFamily;
	}

	public void setbFamily(boolean bFamily) {
		this.bFamily = bFamily;
	}

	public int getiNumBeds() {
		return iNumBeds;
	}

	public void setiNumBeds(int iNumBeds) {
		this.iNumBeds = iNumBeds;
	}

	public int getiNumRows() {
		return iNumRows;
	}

	public void setiNumRows(int iNumRows) {
		this.iNumRows = iNumRows;
	}

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
	public Room()
	{
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
		iRoomId = 0 ;
		iRoomNumber = 0 ;
		iFloor = 0 ;
		iCost = 0 ;
		cOccupancy = ( char ) 0 ;
		bEnsuite = false ;
		bMinibar = false ;
		bJacuzzi = false ;
		bSeaview = false ;
		bHoneymoon = false ;
		bFamily = false ;
		iNumBeds = 0 ;

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
			
				sql = "SELECT count(*) AS rowCount FROM Room;" ;
				
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
	// This will collect the primary key if the requested Room number exists
	// in the database table.
	// This means the index can be used thereafter.
	public boolean getByRoomNumber( int iReqRoom )
	{
		boolean bRC = false ;
		int i ;
		try
		{
			System.err.println( this.getClass().getName()+ ":: DB connected := " + dbSession.isConnected() ) ;
			
			sql = "SELECT RoomId"
					+ ", RoomNumber"
					+ " FROM Room ;" ;

			System.err.println( this.getClass().getName()+ ":: about to exec:= " + sql ) ;
			
			sqlStatement = dbSession.getConnection().createStatement() ;
			resultSet = sqlStatement.executeQuery( sql ) ;
			bRC = resultSet.next() ;
			if ( bRC == true )
			{
				for ( i = 1 ; i <= iNumRows ; i++ )
				{
					if ( resultSet.getInt( "RoomNumber" ) == iReqRoom )
					{
						this.iRoomNumber = iReqRoom ;
						this.iRoomId = resultSet.getInt( "RoomId" ) ;
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
			
			sql = "SELECT RoomId"
					+ ", RoomNumber"
					+ ", Floor"
					+ ", Cost"
					+ ", Occupancy"
					+ ", Ensuite"
					+ ", Minibar"
					+ ", Jacuzzi"
					+ ", Seaview"
					+ ", Honeymoon"
					+ ", Family"
					+ ", NumBeds"
					+ " FROM Room" ;
			
			if ( bId == true )
			{
				// searching by primary key (id)
				sql = sql + " WHERE RoomId = " + input + ";" ;
			}
			else
			{
				// searching by Room number
				sql = sql + " WHERE RoomNumber = " + input + ";" ;
			}
			System.err.println( this.getClass().getName()+ ":: about to exec:= " + sql ) ;
			
			sqlStatement = dbSession.getConnection().createStatement() ;
			resultSet = sqlStatement.executeQuery( sql ) ;
			resultSet.next() ;
			
			iRoomId = resultSet.getInt( "RoomId" ) ;
			iRoomNumber = resultSet.getInt( "RoomNumber" ) ;
			iFloor = ( short ) resultSet.getInt( "Floor" ) ;
			iCost = resultSet.getInt( "Cost" ) ;
			cOccupancy = ( char ) resultSet.getInt( "Occupancy" ) ;
			bEnsuite = resultSet.getBoolean( "Ensuite" ) ;
			bMinibar = resultSet.getBoolean( "Minibar" ) ;
			bJacuzzi = resultSet.getBoolean( "Jacuzzi" ) ;
			bSeaview = resultSet.getBoolean( "SeaView" ) ;
			bHoneymoon = resultSet.getBoolean( "Honeymoon" ) ;
			bFamily = resultSet.getBoolean( "Family" ) ;
			iNumBeds = resultSet.getInt( "NumBeds" ) ;
			
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
	public void collectRecordById( int id )
	{
		collectRecord( true , id ) ;
		return ;
	}
	
	// ----------------------------------------------------------------------
	// to use the main field.
	public void collectRecordByNumber( int iRoomNumber )
	{
		collectRecord( false , iRoomNumber ) ;
		return ;
	}
	
	// ----------------------------------------------------------------------
	// utilities
	// ----------------------------------------------------------------------
	public void display()
	{
		sz = "::display()" ;
		sz = sz + "\n\tRoomId := " + iRoomId ;
		sz = sz + "\n\tRoomNumber := " + iRoomNumber ;
		sz = sz + "\n\tFloor := " + iFloor ;
		sz = sz + "\n\tCost := " + iCost ;
		sz = sz + "\n\tOccupancy := " + ( int ) cOccupancy ;
		sz = sz + "\n\tEnsuite := " + bEnsuite ;
		sz = sz + "\n\tMinibar := " + bMinibar ;
		sz = sz + "\n\tJacuzzi := " + bJacuzzi ;
		sz = sz + "\n\tSeaview := " + bSeaview ;
		sz = sz + "\n\tHoneymoon := " + bHoneymoon ;
		sz = sz + "\n\tFamily := " + bFamily ;
		sz = sz + "\n\tNumBeds := " + iNumBeds ;
		System.out.println( this.getClass().getName() + sz ) ;
		return ;
	}
	
	// ----------------------------------------------------------------------
	// test rig
	// ----------------------------------------------------------------------
	public static void main( String [] args )
	{
		
		Room Room = new Room() ;
		
		
		Room.collectRecordByNumber( 9 ) ;
		Room.display() ;
		
		Room.collectRecordById( 1 ) ;
		Room.display() ;
		
		return ;
	}
}
