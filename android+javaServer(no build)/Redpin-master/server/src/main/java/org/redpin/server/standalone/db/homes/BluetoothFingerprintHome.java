/**
 *  Filename: BluetoothReadingHome.java (in org.redpin.server.standalone.db.homes)
 *  This file is part of the Redpin project.
 * 
 *  Redpin is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as published
 *  by the Free Software Foundation, either version 3 of the License, or
 *  any later version.
 *
 *  Redpin is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *  GNU Lesser General Public License for more details.
 *
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with Redpin. If not, see <http://www.gnu.org/licenses/>.
 *
 *  (c) Copyright ETH Zurich, Luba Rogoleva, Pascal Brogle, Philipp Bolliger, 2010, ALL RIGHTS RESERVED.
 * 
 *  www.redpin.org
 */
package org.redpin.server.standalone.db.homes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.logging.Level;

import org.redpin.server.standalone.core.measure.BluetoothFingerprint;
import org.redpin.server.standalone.core.measure.BluetoothReading;


public class BluetoothFingerprintHome extends EntityHome<BluetoothFingerprint> {
	

	
	private static final String[] TableCols = {"mapid", "locid", "rssi", "bluetoothaddress", "mapXCord", "mapYCord"};
	private static final String TableName = "bluetoothfingerprint"; 
	private static final String TableIdCol = "bluetoothmeasurementid";

	public BluetoothFingerprintHome() {
		super();
	}
	
	
	
	/**
	 * @see EntityHome#getTableName()
	 */
	@Override
	protected String getTableName() {
		return TableName;
	}
	
	/**
	 * @see EntityHome#getTableIdCol()
	 */
	@Override
	protected String getTableIdCol() {
		return TableIdCol;
	}
	
	/**
	 * @see EntityHome#getTableCols()
	 */
	@Override
	protected String[] getTableCols() {
		return TableCols;
	}
	
	/**
	 * @see EntityHome#parseResultRow(ResultSet)
	 */
	@Override
	public BluetoothFingerprint parseResultRow(final ResultSet rs, int fromIndex) throws SQLException{
		System.out.println("result set in Bluetooth Fingerprint: "+ rs);
		BluetoothFingerprint reading = new BluetoothFingerprint();
		
		try {
			reading.setId(rs.getInt(fromIndex));
			//reading.setId(rs.getString(fromIndex + 1));
			reading.setBluetoothAddress(rs.getString(fromIndex + 2));
			//reading.setMajorDeviceClass(rs.getString(fromIndex + 3));
	//		reading.setMinorDeviceClass(rs.getString(fromIndex + 4));		
		
		} catch (SQLException e) {
			log.log(Level.SEVERE, "parseResultRow failed: " + e.getMessage(), e);
			throw e;
		}
		
		return reading;
	}

	@Override
	public int fillInStatement(PreparedStatement ps, BluetoothFingerprint t, int fromIndex)
			throws SQLException {
		return fillInStatement(ps, new Object[] {t.getBluetoothAddress(), t.getmapYCord(), t.getBluetoothrssi(), t.getmapid()},   
			new int[]{Types.VARCHAR, Types.INTEGER, Types.INTEGER, Types.INTEGER},
			fromIndex);

	}



	

}
