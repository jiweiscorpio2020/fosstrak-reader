package org.fosstrak.reader.rprm.core.mgmt.agent.snmp.table ;

import junit.framework.TestCase;

import org.fosstrak.reader.rprm.core.ReaderDevice;
import org.fosstrak.reader.rprm.core.mgmt.agent.snmp.SnmpAgent;
import org.fosstrak.reader.rprm.core.mgmt.agent.snmp.table.EpcgReaderServerTableRowStatusListener;
import org.fosstrak.reader.rprm.core.mgmt.agent.snmp.table.RowObjectContainer;
import org.fosstrak.reader.rprm.core.mgmt.agent.snmp.table.SnmpTableRow;
import org.fosstrak.reader.rprm.core.mgmt.agent.snmp.table.EpcgReaderServerTableRow.ServerTypeEnum;
import org.fosstrak.reader.rprm.core.mgmt.agent.snmp.table.SnmpTable.TableTypeEnum;
import org.fosstrak.reader.rprm.core.msg.MessageLayer;
import org.apache.log4j.xml.DOMConfigurator;
import org.snmp4j.agent.mo.snmp.RowStatus;
import org.snmp4j.agent.mo.snmp.RowStatusEvent;

/**
 * Tests for the class <code>org.fosstrak.reader.mgmt.agent.snmp.table.EpcgReaderServerTableRowStatusListener</code>.
 */
public class EpcgReaderServerTableRowStatusListenerTest extends TestCase {

	private EpcgReaderServerTableRowStatusListener rowStatusListener;
	private ReaderDevice readerDevice;

	/**
	 * Sets up the test.
	 * @exception Exception An error occurred
	 */
	protected final void setUp() throws Exception {
		super.setUp();

		DOMConfigurator.configure("./target/classes/props/log4j.xml");

		if (SnmpAgent.getInstance() == null) {
			MessageLayer.main(new String[] { });
		}

		readerDevice = ReaderDevice.getInstance();

		rowStatusListener = new EpcgReaderServerTableRowStatusListener(readerDevice);
	}

	/**
	 * Does the cleanup.
	 * @exception Exception An error occurred
	 */
	protected final void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Tests the <code>rowStatusChanged()</code> method.
	 */
	public final void testRowStatusChanged() {
		String dhcp = "192.168.1.1/67";
		SnmpTableRow row = SnmpTableRow.getSnmpTableRow(new RowObjectContainer(TableTypeEnum.EPCG_READER_SERVER_TABLE, new Object[] { ServerTypeEnum.DHCP, dhcp }));
		RowStatusEvent event = new RowStatusEvent(row, null, row, null, RowStatus.active, RowStatus.destroy);
		rowStatusListener.rowStatusChanged(event);
//		assertTrue(!dhcp.equals(readerDevice.getDHCPServer())); // TODO: activate this
	}

	/**
	 * Runs the test using the gui runner.
	 * @param args No arguments
	 */
	public static void main(String[] args) {
        junit.swingui.TestRunner.run(EpcgReaderServerTableRowStatusListenerTest.class);
    }

}
