package src.main.java.fr.but.info.sae122;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestPath {

	@Test
	void testConstructor() {
		Path path1 = new Path();
		Path path2;
		String nodes[] = {"N1", "N2", "N3"};
		
		assertNotNull(path1);
		try {
			path2 = new Path(nodes);
			assertNotNull(path2);
		} catch (IncoherentSuccessivityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
