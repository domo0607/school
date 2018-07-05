import java.sql.* ;
import java.util.Date ;

public class Booking
{
	// ----------------------------------------------------------------------
	// Class variables
	// ----------------------------------------------------------------------
	// fields in db-table.
	private int iBookingID ;
	private int iRoomID ;
	private int iGuestID ;
	private Date iETA ;
	private Date iETD ;
	private Date iDateBooked ;
	private int iRoomNumber ;
	
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
	public Booking()
	{
		reset() ;
		iETA = new Date();
		iETD = new Date();
		iDateBooked = new Date();
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
		iBookingID = 0 ;
		iRoomID = 0 ;
		iGuestID = 0 ;
		//iETA = 0 ;
		//iETD = 0 ;
		//iDateBooked = 0 ;
	
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
			
				sql = "SELECT count(*) AS rowCount FROM Bookinh;" ;
				
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
			
			sql = "SELECT BookingID"
					+ ", RoomID"
					+ ", GuestID"
					+ ", ETA"
					+ ", ETD"
					+ ", DateBooked"
					+ " FROM Booking " ;
			
			if ( bId == true )
			{
				// searching by primary key (id)
				sql = sql + " WHERE BookingID = " + input + ";" ;
			}
			
			System.err.println( this.getClass().getName()+ ":: about to exec:= " + sql ) ;
			
			sqlStatement = dbSession.getConnection().createStatement() ;
			resultSet = sqlStatement.executeQuery( sql ) ;
			resultSet.next() ;
			
			iBookingID = resultSet.getInt( "BookingID" ) ;
			iRoomID = resultSet.getInt( "RoomID" ) ;
			iGuestID = resultSet.getInt( "GuestID" ) ;
			iETA = resultSet.getDate( "ETA" ) ;
			iETD = resultSet.getDate( "ETD" ) ;
			iDateBooked = resultSet.getDate( "DateBooked" ) ;
			
			
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
	public void collectRecordByBookingID( int id )
	{
		collectRecord( true , id ) ;
		return ;
	}
	
	// ----------------------------------------------------------------------
	// to use the main field.

	public void collectRecordByGuestID( int id )
	{
		collectRecord( true , id ) ;
		return ;
	}
	// ----------------------------------------------------------------------
	// utilities
	// ----------------------------------------------------------------------
	public void display()
	{
		sz = "::display()" ;
		sz = sz + "\n\tBookinhID := " + iBookingID ;
		sz = sz + "\n\tRoomiD := " + iRoomID ;
		sz = sz + "\n\tGuestID := " + iGuestID ;
		sz = sz + "\n\tETA := " + iETA ;
		sz = sz + "\n\tETD := " + iETD ;
		sz = sz + "\n\tDateBooked := " + iDateBooked ;
		System.out.println( this.getClass().getName() + sz ) ;
		return ;
	}
	
	// ----------------------------------------------------------------------
	// test rig
	// ----------------------------------------------------------------------
	public static void main( String [] args )
	{
		Booking Booking = new Booking() ;
		
		Booking.collectRecordByBookingID( 1 ) ;
		Booking.display() ;
		
		Booking.collectRecordByGuestID( 2 ) ;
		Booking.display() ;
		
		
		return ;
	}
	
}
