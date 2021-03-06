/*
 * Copyright (C) 2007 ETH Zurich
 *
 * This file is part of Fosstrak (www.fosstrak.org).
 *
 * Fosstrak is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License version 2.1, as published by the Free Software Foundation.
 *
 * Fosstrak is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with Fosstrak; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin Street, Fifth Floor,
 * Boston, MA  02110-1301  USA
 */

package org.fosstrak.reader.rprm.core.mgmt.alarm;

import org.fosstrak.reader.rprm.core.ReaderDevice;
import org.fosstrak.reader.rprm.core.mgmt.OperationalStatus;

/**
 * <code>TTOperStatusAlarm</code> extends the <code>Alarm</code> class, and
 * is the base class for all Transition Triggered Operational Status Alarms. The
 * base class identifies the particular transition between Operational Status
 * states that triggered the alarm.
 */
public class TTOperStatusAlarm extends Alarm {

	/**
	 * The originating <code>OperationalStatus</code> before the
	 * <code>Alarm</code> is generated.
	 */
	protected OperationalStatus fromState;

	/**
	 * The <code>OperationalStatus</code> at the time the <code>Alarm</code>
	 * is generated.
	 */
	protected OperationalStatus toState;

	/**
	 * Protected constructor.
	 * 
	 * @param name
	 *            The name of the alarm identifying the type of alarm, e.g.,
	 *            "TTOperStatusAlarm"
	 * @param alarmLevel
	 *            The severity level of the alarm
	 * @param readerDevice
	 *            The reader device
	 * @param fromState
	 *            The originating <code>OperationalStatus</code> before the
	 *            <code>Alarm</code> is generated
	 * @param toState
	 *            The <code>OperationalStatus</code> at the time the
	 *            <code>Alarm</code> is generated
	 */
	protected TTOperStatusAlarm(String name, AlarmLevel alarmLevel,
			ReaderDevice readerDevice, OperationalStatus fromState,
			OperationalStatus toState) {
		super(name, alarmLevel, readerDevice);
		this.fromState = fromState;
		this.toState = toState;
	}
	
	/**
	 * Returns the originating <code>OperationalStatus</code> before the
	 * <code>Alarm</code> is generated.
	 * 
	 * @return The <code>OperationalStatus</code> before the transition
	 */
	public OperationalStatus getFromState() {
		return fromState;
	}
	
	/**
	 * Returns the <code>OperationalStatus</code> at the time the
	 * <code>Alarm</code> is generated.
	 * 
	 * @return The <code>OperationalStatus</code> after the transition
	 */
	public OperationalStatus getToState() {
		return toState;
	}

}
