package edu.ilstu;


/** 
 * Driver for Program 6
 
 * @author Lauren Kapraun
 *
 */
public class TrackDriver
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Track track = new Track();
		TrackInput.readTrackData(track);
		TrackInput.readTransactionData(track);
	}

}
