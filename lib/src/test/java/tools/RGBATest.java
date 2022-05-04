package tools;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class RGBATest {

	private RGBA rgba;
	@Before
	public void setUpBeforeClass() throws Exception {
		rgba = new RGBA();
	}

	@Test
	public void test() {
		assertEquals("FF should result to 255",rgba.hexToDecimal("ff"),255);
		assertEquals("FFFF should result to 65,535",rgba.hexToDecimal("ffff"),65535);
		assertEquals("ff3EA2 should result to 16,727,714",rgba.hexToDecimal("ff3EA2"),16727714);
	}

}
